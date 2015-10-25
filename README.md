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

  
