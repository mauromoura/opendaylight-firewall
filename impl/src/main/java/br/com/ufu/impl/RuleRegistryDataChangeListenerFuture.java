/*
 * Copyright © 2015 Mauro Ramos and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package br.com.ufu.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataBroker;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.RuleRegistry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.AbstractFuture;

public class RuleRegistryDataChangeListenerFuture extends AbstractFuture<RuleRegistryEntry> implements DataChangeListener,AutoCloseable{

  private static final Logger LOG = LoggerFactory.getLogger(RuleRegistryDataChangeListenerFuture.class);
  private ListenerRegistration<DataChangeListener> registration;

  public RuleRegistryDataChangeListenerFuture(DataBroker db) {
    InstanceIdentifier<RuleRegistry> ruleIID =
        InstanceIdentifier.builder(RuleRegistry.class).build();
    db.registerDataChangeListener(LogicalDatastoreType.CONFIGURATION, ruleIID, this,
        AsyncDataBroker.DataChangeScope.SUBTREE);
    LOG.info("DataChangeListener registered with MD-SAL for path {}", ruleIID);
  }

  @Override
  public void close() throws Exception {
    if (registration != null) {
      registration.close();
    }
  }

  @Override
  public void onDataChanged(AsyncDataChangeEvent<InstanceIdentifier<?>, DataObject> change) {
    LOG.info("dataChanged");
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
      quietClose();
      return super.cancel(mayInterruptIfRunning);
  }

  private void quietClose() {
    try {
      this.close();
    } catch (Exception e) {
      throw new IllegalStateException("Unable to close registration", e);
    }
  }


}
