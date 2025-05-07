#!/bin/bash
echo "Building Docker image..."
docker build -t menu-svc .
if [ $? -ne 0 ]; then
    echo "Failed to build the Docker image."
    exit 1
fi

echo "Running Docker container..."
docker run -p 9091:9091 menu-svc
if [ $? -ne 0 ]; then
    echo "Failed to run the Docker container."
    exit 1
fi

echo "Docker menu-svc container started successfully."
