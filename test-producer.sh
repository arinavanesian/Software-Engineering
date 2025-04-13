#!/bin/bash

docker exec -it kafka \
  kafka-console-producer \
  --bootstrap-server localhost:9092 \
  --topic messages
