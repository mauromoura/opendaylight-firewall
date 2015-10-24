package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105;
import org.opendaylight.yangtools.yang.binding.RpcService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import java.util.concurrent.Future;


/**
 * Interface for implementing the following YANG RPCs defined in module &lt;b&gt;sdnfirewall&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF/yang/sdnfirewall.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * rpc add-rule {
 *     input {
 *         leaf name {
 *             type string;
 *         }
 *         leaf node {
 *             type string;
 *         }
 *         leaf ip-addr {
 *             type string;
 *         }
 *         leaf port {
 *             type string;
 *         }
 *     }
 *     
 *     output {
 *         leaf greeting {
 *             type string;
 *         }
 *     }
 *     status CURRENT;
 * }
 * &lt;/pre&gt;
 *
 */
public interface SdnfirewallService
    extends
    RpcService
{




    Future<RpcResult<AddRuleOutput>> addRule(AddRuleInput input);

}

