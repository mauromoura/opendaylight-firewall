/*
 * Copyright © 2015 Mauro Ramos and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package br.com.ufu.impl;

import java.util.concurrent.Future;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.common.api.data.TransactionCommitFailedException;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.Table;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.TableKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.Flow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.MatchBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.AddRuleInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.AddRuleOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.AddRuleOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.RuleRegistry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.RuleRegistryBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.SdnfirewallService;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.Futures;

public class SdnfirewallImpl implements SdnfirewallService {

  private static final Logger LOG = LoggerFactory.getLogger(SdnfirewallImpl.class);
  private DataBroker db;

  public SdnfirewallImpl(DataBroker db) {
    this.db = db;
    initializeDataTree(db);
  }

  @Override
  public Future<RpcResult<AddRuleOutput>> addRule(AddRuleInput input) {

    NodeId nodeId = new NodeId(input.getNode());

    // Creating match object
    MatchBuilder matchBuilder = new MatchBuilder();
    MatchUtils.createDstL3IPv4Match(matchBuilder, new Ipv4Prefix(input.getIpAddr()));
    MatchUtils
        .createSetDstTcpMatch(matchBuilder, new PortNumber(Integer.parseInt(input.getPort())));

    /*
     * Create Flow
     */
    String flowId = "New firewall rule" + input.getName();
    FlowBuilder flowBuilder = new FlowBuilder();
    flowBuilder.setMatch(matchBuilder.build());
    flowBuilder.setId(new FlowId(flowId));
    FlowKey key = new FlowKey(new FlowId(flowId));
    flowBuilder.setBarrier(true);
    flowBuilder.setTableId((short) 0);
    flowBuilder.setKey(key);
    flowBuilder.setPriority(32768);
    flowBuilder.setFlowName(flowId);
    flowBuilder.setHardTimeout(0);
    flowBuilder.setIdleTimeout(0);

    /*
     * Perform transaction to store rule
     */
    InstanceIdentifier<Flow> flowIID =
        InstanceIdentifier.builder(Nodes.class).child(Node.class, new NodeKey(nodeId))
            .augmentation(FlowCapableNode.class)
            .child(Table.class, new TableKey(flowBuilder.getTableId()))
            .child(Flow.class, flowBuilder.getKey()).build();

    Preconditions.checkNotNull(db);
    WriteTransaction transaction = db.newWriteOnlyTransaction();
    transaction.merge( LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(),true);
    CheckedFuture<Void, TransactionCommitFailedException> future = transaction.submit();
    Futures.addCallback(future, new LoggingFuturesCallBack<Void>("Failed add firewall rule", LOG));

    LOG.info("Added firewall rule with ip {} and port {} into node {}", input.getIpAddr());

    AddRuleOutput output =
        new AddRuleOutputBuilder().setGreeting("Added firewall rule").build();
    return RpcResultBuilder.success(output).buildFuture();

  }

  private void initializeDataTree(DataBroker db) {
    LOG.info("Preparing to initialize the rules registry");
    WriteTransaction transaction = db.newWriteOnlyTransaction();
    InstanceIdentifier<RuleRegistry> iid = InstanceIdentifier.create(RuleRegistry.class);
    RuleRegistry greetingRegistry = new RuleRegistryBuilder().build();
    transaction.put(LogicalDatastoreType.OPERATIONAL, iid, greetingRegistry);
    CheckedFuture<Void, TransactionCommitFailedException> future = transaction.submit();
    Futures.addCallback(future, new LoggingFuturesCallBack<>("Failed to create rules registry",
        LOG));
  }

}
