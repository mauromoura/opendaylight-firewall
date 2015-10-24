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
    AddRuleOutput output =
        new AddRuleOutputBuilder().setGreeting("Hello " + input.getName()).build();
    return RpcResultBuilder.success(output).buildFuture();
  }

  private void initializeDataTree(DataBroker db) {
    LOG.info("Preparing to initialize the greeting registry");
    WriteTransaction transaction = db.newWriteOnlyTransaction();
    InstanceIdentifier<RuleRegistry> iid = InstanceIdentifier.create(RuleRegistry.class);
    RuleRegistry greetingRegistry = new RuleRegistryBuilder()
            .build();
    transaction.put(LogicalDatastoreType.OPERATIONAL, iid, greetingRegistry);
    CheckedFuture<Void, TransactionCommitFailedException> future = transaction.submit();
    Futures.addCallback(future, new LoggingFuturesCallBack<>("Failed to create greeting registry", LOG));
}

}
