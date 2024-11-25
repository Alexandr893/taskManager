
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/TaskManager-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9050

ENTRYPOINT ["java", "-jar", "app.jar"]