@echo off
echo Building Docker menu-svc image...
cd ..
docker build -t menu-svc -f .docker/Dockerfile .
if %ERRORLEVEL% neq 0 (
    echo Failed to build the Docker image.
    exit /b %ERRORLEVEL%
)

echo Running Docker menu-svc container...
docker run -p 9091:9091 menu-svc
if %ERRORLEVEL% neq 0 (
    echo Failed to run the Docker container.
    exit /b %ERRORLEVEL%
)

echo Docker menu-svc container started successfully.
