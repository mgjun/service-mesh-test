#!/bin/sh

java -jar -Djava.security.egd=file:/dev/./urandom app.jar &
envoy -c /etc/service-envoy.yaml --service-cluster service${SERVICE_NAME}