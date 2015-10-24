/*
 * Copyright © 2015 Mauro Ramos and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.impl.rev141210;

import br.com.ufu.impl.SdnfirewallProvider;

public class SdnfirewallModule extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.impl.rev141210.AbstractSdnfirewallModule {
    public SdnfirewallModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public SdnfirewallModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.impl.rev141210.SdnfirewallModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        SdnfirewallProvider provider = new SdnfirewallProvider();
        getBrokerDependency().registerProvider(provider);
        return provider;
    }

}
