FROM eclipse-temurin:21-jdk
MAINTAINER Ramina
COPY backend.jar fitnessbackend.jar
ENTRYPOINT ["java", "-jar", "fitnessbackend.jar"]
