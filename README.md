# opendaylight-firewall

A litte experiment that tries to ensure a security policy into a set o openflow switches, similar to a firewall or a ACL, using Opendaylight Controller.

## Requirements
* [Maven](https://maven.apache.org/)
* [Mininet](http://mininet.org/) 

## Walkthrough
1.  Clone the repository

  https://github.com/mauromoura/opendaylight-firewall.git

2. Compile with maven

  mvn clean install -DskipTests

3. Run Opendaylight controller

  karaf/target/assembly/bin/karaf

4. Create a topology with mininet
  >If you are using a VM with VirtualBox, male sure to use *Host-only networking* so your virtual swithes can comunicate with the controller running on the host machine.

  sudo mn --topo single,3 --mac --switch ovsk --controller remote,ip=*{controller_ip}*

5. Add some flows to the switchs using openvswitch

  ovs-ofctl add-flow s1 in_port=1,actions=output:2
  
  ovs-ofctl add-flow s1 in_port=2,actions=output:1

6. Test the conectivity between the clients in mininet

  h1 ping h2
  
  h2 ping h1
  
7. Adding security rules to opendaylight
  
  Security rules can be added to the controller using restconf. To add a rule, you can make a POST to:

  http://localhost:8181/restconf/config/sdnfirewall:rule-registry/
  
  The security rule must be a JSON with the format :
  
  {"rule-registry-entry":
   [{
      "name":"name_of_security_rule [test]",
      "node":"switch_name [openflow:1]",
      "ip-addr":"ip_ to block_traffic [10.0.0.2/24]",
      "port":"port [8080]"
    }]
  }

  To view previosly saved rules, send a GET request to the same URL.
