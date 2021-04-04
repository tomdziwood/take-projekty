#!/bin/sh
mvn clean package && docker build -t pl.put.poznan/Requests .
docker rm -f Requests || true && docker run -d -p 9080:9080 -p 9443:9443 --name Requests pl.put.poznan/Requests