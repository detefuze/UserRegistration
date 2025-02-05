# Базовый образ с Java
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/UserRegistration-1.0-SNAPSHOT.jar /app/UserRegistration-1.0-SNAPSHOT.jar
COPY .env /app/.env

ENTRYPOINT ["java", "-jar", "UserRegistration-1.0-SNAPSHOT.jar"]