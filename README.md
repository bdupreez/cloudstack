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

Launch Kong:

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



Launch Tyk:

    ./APIManagers/tyk-start.sh

Setup:

Launch WSO2:

    ./APIManagers/wso2-start.sh


Setup:
