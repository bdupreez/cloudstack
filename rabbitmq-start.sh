#!/usr/bin/env bash

docker run -d --hostname my-rabbit --name some-rabbit -p 5672:5672 rabbitmq:latest