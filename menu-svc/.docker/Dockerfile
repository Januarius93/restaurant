FROM amazoncorretto:20-alpine-jdk AS build
EXPOSE 9091
COPY target/menu-svc-0.0.1-SNAPSHOT.jar menu-svc.jar
ENTRYPOINT ["java", "-jar", "/menu-svc.jar"]
