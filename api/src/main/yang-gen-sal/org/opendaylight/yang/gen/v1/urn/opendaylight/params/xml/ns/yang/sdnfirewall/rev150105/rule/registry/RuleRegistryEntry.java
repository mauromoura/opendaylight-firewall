package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.RuleRegistry;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;sdnfirewall&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF/yang/sdnfirewall.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * list rule-registry-entry {
 *     key "name"
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
 * &lt;i&gt;sdnfirewall/rule-registry/rule-registry-entry&lt;/i&gt;
 *
 * &lt;p&gt;To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntryBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntryBuilder
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntryKey
 *
 */
public interface RuleRegistryEntry
    extends
    ChildOf<RuleRegistry>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>,
    Identifiable<RuleRegistryEntryKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(
        org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:sdnfirewall", "2015-01-05", "rule-registry-entry"));

    java.lang.String getName();
    
    java.lang.String getNode();
    
    java.lang.String getIpAddr();
    
    java.lang.String getPort();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    RuleRegistryEntryKey getKey();

}

