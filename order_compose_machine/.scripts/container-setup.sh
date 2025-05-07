#!/bin/bash
echo "Building Docker order-compose-machine image..."
docker build -t order-compose-machine .
if [ $? -ne 0 ]; then
    echo "Failed to build the Docker image."
    exit 1
fi

echo "Running Docker order-compose-machine container..."
docker run -p 9090:9090 order-compose-machine
if [ $? -ne 0 ]; then
    echo "Failed to run the Docker container."
    exit 1
fi

echo "Docker order-compose-machine container started successfully."
