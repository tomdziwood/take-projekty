@echo off
call mvn clean package
call docker build -t pl.put.poznan/Requests .
call docker rm -f Requests
call docker run -d -p 9080:9080 -p 9443:9443 --name Requests pl.put.poznan/Requests