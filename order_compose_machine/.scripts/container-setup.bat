@echo off
echo Building Docker image...
cd ..
docker build -t order-compose-machine -f .docker/Dockerfile .
if %ERRORLEVEL% neq 0 (
    echo Failed to build the Docker image.
    exit /b %ERRORLEVEL%
)

echo Running Docker container...
docker run -p 9090:9090 order-compose-machine
if %ERRORLEVEL% neq 0 (
    echo Failed to run the Docker container.
    exit /b %ERRORLEVEL%
)

echo Docker container started successfully.
