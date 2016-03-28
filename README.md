# Spring Cloud + Netflix + API Managers - Kong, Tyk and WSO2

Requires:

 - [docker](https://docs.docker.com/installation/) and [compose](https://docs.docker.com/compose/install/)
    * Rabbit MQ - (Spring Cloud + Netflix)
    * Cassandra - (Kong)
    * MongoDB - (Tyk)
    * Redis - (Tyk)

Launch RabbitMQ:
    
    ./rabbitmq-start

Start up Spring Cloud Components in IDE or Maven Boot Plugin :

     Eureka/src/main/java/net/briandupreez/EurekaApplication.java
     Config/src/main/java/net/briandupreez/ConfigApplication.java
     MicroSerive/src/main/java/net/briandupreez/MicroserviceApplication.java


Check PostMan:

    http://localhost:8080/cities
    http://localhost:8080/version

Check Eureka:
[Eureka](http://localhost:8761)


##Launch Kong:

    ./APIManagers/kong-start.sh

Check:
[Kong Dashboard](http://dockerhost:9999/#/config)


###Setup:

Add API:
- Name: Cities
- Request host: Blank
- Request path: /cities
- Upstream url: http://<ipaddress of local>:8080

Add Consumer:
- Name: any
- Create Add Key Auth

Add Key Auth Plugin


##Launch Tyk:

    ./APIManagers/tyk-start.sh

###Setup:
 Settings are in tyk.conf
 Then run APIManagers > Tyk

    ./setup.sh 192.168.99.100 <DockerIP>

Add API:
- Name: Cities
- Listen path: /cities
- Target url: http://<ipaddress of local>:8080/cities
- Add Auth token - Authorisation

Create Key:
- Name: Cities
- Pick Never Expires... if you dont want it to break every hour
- Access Rights: Select Cities API
- Create - copy key (56f81057d32208000100000122729f8ad80f403457b95620b73c0a78)

?Application was staged at: null

##Launch WSO2:

    ./APIManagers/wso2-start.sh


###Setup:

Had Issues trying to use docker, IP / Host / Provider..
Reverted to launching WSO2 Directly

Add API:
 - [Publisher](https://localhost:9443/publisher) - admin admin
 - Select have an existing API > then start creating, if you have swagger api... then can using that (io.springfox swagger does not work with spring data rest HAL representation)
 - Name: demo
 - version: 1.0
 - API Definition: add /cities, select get.. click add
 - Implementation: add http://localhost:8080 for prod and sandbox
 - Manage: select tier... publish..

API Store:
 - [API Store](https://localhost:9443/store) - admin admin
 - Goto subscriptions - generate keys
 - Goto api - subscribe
 - Goto api console tab... test api

Then had what seems to be cert issues...

could not call via postman even though could call via their test on API store.
added header to chrome, accessed api like that... after that postman worked
