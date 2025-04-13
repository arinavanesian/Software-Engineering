#!/bin/bash

docker compose up -d

# Wait for PostgreSQL 
while ! docker exec message_db pg_isready -U message_user -d message_processor > /dev/null 2>&1; do
  echo "Waiting for PostgreSQL..."
  sleep 2
done
# Wait for Kafka 
while ! docker exec kafka kafka-broker-api-versions --bootstrap-server localhost:9092 > /dev/null 2>&1; do
  echo "Waiting for Kafka..."
  sleep 5
done
# Kafka topic 
docker exec kafka kafka-topics --create \
  --bootstrap-server localhost:9092 \
  --replication-factor 1 \
  --partitions 3 \
  --topic messages

echo "All services are ready!"
