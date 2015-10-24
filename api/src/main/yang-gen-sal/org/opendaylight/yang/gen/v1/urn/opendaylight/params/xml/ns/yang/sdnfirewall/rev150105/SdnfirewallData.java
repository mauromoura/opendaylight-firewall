package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105;
import org.opendaylight.yangtools.yang.binding.DataRoot;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;sdnfirewall&lt;/b&gt;
 * &lt;br&gt;Source path: &lt;i&gt;META-INF/yang/sdnfirewall.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * module sdnfirewall {
 *     yang-version 1;
 *     namespace "urn:opendaylight:params:xml:ns:yang:sdnfirewall";
 *     prefix "sdnfirewall";
 *
 *     revision 2015-01-05 {
 *         description "";
 *     }
 *
 *     container rule-registry {
 *         list rule-registry-entry {
 *             key "name"
 *             leaf name {
 *                 type string;
 *             }
 *             leaf node {
 *                 type string;
 *             }
 *             leaf ip-addr {
 *                 type string;
 *             }
 *             leaf port {
 *                 type string;
 *             }
 *         }
 *     }
 *
 *     rpc add-rule {
 *         input {
 *             leaf name {
 *                 type string;
 *             }
 *             leaf node {
 *                 type string;
 *             }
 *             leaf ip-addr {
 *                 type string;
 *             }
 *             leaf port {
 *                 type string;
 *             }
 *         }
 *         
 *         output {
 *             leaf greeting {
 *                 type string;
 *             }
 *         }
 *         status CURRENT;
 *     }
 * }
 * &lt;/pre&gt;
 *
 */
public interface SdnfirewallData
    extends
    DataRoot
{




    RuleRegistry getRuleRegistry();

}

