FROM amazoncorretto:20-alpine-jdk AS build
EXPOSE 9090
COPY target/order-compose-machine-0.0.1-SNAPSHOT.jar order-compose-machine.jar
ENTRYPOINT ["java", "-jar", "/order-compose-machine.jar"]
