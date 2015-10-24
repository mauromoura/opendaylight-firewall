package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;sdnfirewall&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF/yang/sdnfirewall.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * container input {
 *     leaf name {
 *         type string;
 *     }
 *     leaf node {
 *         type string;
 *     }
 *     leaf ip-addr {
 *         type string;
 *     }
 *     leaf port {
 *         type string;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;sdnfirewall/add-rule/input&lt;/i&gt;
 *
 * &lt;p&gt;To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.AddRuleInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.AddRuleInputBuilder
 *
 */
public interface AddRuleInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.AddRuleInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(
        org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:sdnfirewall", "2015-01-05", "input"));

    java.lang.String getName();
    
    java.lang.String getNode();
    
    java.lang.String getIpAddr();
    
    java.lang.String getPort();

}

