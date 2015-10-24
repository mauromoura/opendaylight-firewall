/*
 * Copyright © 2015 Mauro Ramos and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package br.com.ufu.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.SdnfirewallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdnfirewallProvider implements BindingAwareProvider, AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(SdnfirewallProvider.class);
    private RpcRegistration<SdnfirewallService> sdnfirewallService;

    @Override
    public void onSessionInitiated(ProviderContext session) {
        LOG.info("SdnfirewallProvider Session Initiated");
        DataBroker db = session.getSALService(DataBroker.class);
        sdnfirewallService = session.addRpcImplementation(SdnfirewallService.class, new SdnfirewallImpl(db));
    }

    @Override
    public void close() throws Exception {
        LOG.info("SdnfirewallProvider Closed");
        if (sdnfirewallService!=null){
          sdnfirewallService.close();
        }
    }

}
