#!/usr/bin/env bash

docker-compose -f Kong/docker-compose.yml up


#docker run -p 9042:9042 -d --name cassandra cassandra:2.2.5
#
#docker run -d --name kong \
#            --link cassandra:cassandra \
#            -p 8000:8000 \
#            -p 8443:8443 \
#            -p 8001:8001 \
#            -p 7946:7946 \
#            -p 7946:7946/udp \
#            --security-opt seccomp:unconfined \
#            mashape/kong
##
#docker run -d -p 9999:8080 pgbi/kong-dashboard
