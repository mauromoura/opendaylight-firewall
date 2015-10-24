package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry
 *
 */
public class RuleRegistryEntryBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry> {

    private java.lang.String _ipAddr;
    private RuleRegistryEntryKey _key;
    private java.lang.String _name;
    private java.lang.String _node;
    private java.lang.String _port;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>> augmentation = Collections.emptyMap();

    public RuleRegistryEntryBuilder() {
    }

    public RuleRegistryEntryBuilder(RuleRegistryEntry base) {
        if (base.getKey() == null) {
            this._key = new RuleRegistryEntryKey(
                base.getName()
            );
            this._name = base.getName();
        } else {
            this._key = base.getKey();
            this._name = _key.getName();
        }
        this._ipAddr = base.getIpAddr();
        this._node = base.getNode();
        this._port = base.getPort();
        if (base instanceof RuleRegistryEntryImpl) {
            RuleRegistryEntryImpl impl = (RuleRegistryEntryImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.String getIpAddr() {
        return _ipAddr;
    }
    
    public RuleRegistryEntryKey getKey() {
        return _key;
    }
    
    public java.lang.String getName() {
        return _name;
    }
    
    public java.lang.String getNode() {
        return _node;
    }
    
    public java.lang.String getPort() {
        return _port;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public RuleRegistryEntryBuilder setIpAddr(java.lang.String value) {
        this._ipAddr = value;
        return this;
    }
    
    public RuleRegistryEntryBuilder setKey(RuleRegistryEntryKey value) {
        this._key = value;
        return this;
    }
    
    public RuleRegistryEntryBuilder setName(java.lang.String value) {
        this._name = value;
        return this;
    }
    
    public RuleRegistryEntryBuilder setNode(java.lang.String value) {
        this._node = value;
        return this;
    }
    
    public RuleRegistryEntryBuilder setPort(java.lang.String value) {
        this._port = value;
        return this;
    }
    
    public RuleRegistryEntryBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public RuleRegistryEntryBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public RuleRegistryEntry build() {
        return new RuleRegistryEntryImpl(this);
    }

    private static final class RuleRegistryEntryImpl implements RuleRegistryEntry {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry.class;
        }

        private final java.lang.String _ipAddr;
        private final RuleRegistryEntryKey _key;
        private final java.lang.String _name;
        private final java.lang.String _node;
        private final java.lang.String _port;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>> augmentation = Collections.emptyMap();

        private RuleRegistryEntryImpl(RuleRegistryEntryBuilder base) {
            if (base.getKey() == null) {
                this._key = new RuleRegistryEntryKey(
                    base.getName()
                );
                this._name = base.getName();
            } else {
                this._key = base.getKey();
                this._name = _key.getName();
            }
            this._ipAddr = base.getIpAddr();
            this._node = base.getNode();
            this._port = base.getPort();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getIpAddr() {
            return _ipAddr;
        }
        
        @Override
        public RuleRegistryEntryKey getKey() {
            return _key;
        }
        
        @Override
        public java.lang.String getName() {
            return _name;
        }
        
        @Override
        public java.lang.String getNode() {
            return _node;
        }
        
        @Override
        public java.lang.String getPort() {
            return _port;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        private int hash = 0;
        private volatile boolean hashValid = false;
        
        @Override
        public int hashCode() {
            if (hashValid) {
                return hash;
            }
        
            final int prime = 31;
            int result = 1;
            result = prime * result + Objects.hashCode(_ipAddr);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_name);
            result = prime * result + Objects.hashCode(_node);
            result = prime * result + Objects.hashCode(_port);
            result = prime * result + Objects.hashCode(augmentation);
        
            hash = result;
            hashValid = true;
            return result;
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DataObject)) {
                return false;
            }
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry)obj;
            if (!Objects.equals(_ipAddr, other.getIpAddr())) {
                return false;
            }
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_name, other.getName())) {
                return false;
            }
            if (!Objects.equals(_node, other.getNode())) {
                return false;
            }
            if (!Objects.equals(_port, other.getPort())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                RuleRegistryEntryImpl otherImpl = (RuleRegistryEntryImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdnfirewall.rev150105.rule.registry.RuleRegistryEntry>> e : augmentation.entrySet()) {
                    if (!e.getValue().equals(other.getAugmentation(e.getKey()))) {
                        return false;
                    }
                }
                // .. and give the other one the chance to do the same
                if (!obj.equals(this)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("RuleRegistryEntry [");
            boolean first = true;
        
            if (_ipAddr != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipAddr=");
                builder.append(_ipAddr);
             }
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
             }
            if (_name != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_name=");
                builder.append(_name);
             }
            if (_node != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_node=");
                builder.append(_node);
             }
            if (_port != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_port=");
                builder.append(_port);
             }
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("augmentation=");
            builder.append(augmentation.values());
            return builder.append(']').toString();
        }
    }

}
