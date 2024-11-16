
FROM openjdk:23-jdk-slim
WORKDIR /TaskManager
COPY target/TaskManager-0.0.1-SNAPSHOT.jar TaskManager.jar
ENTRYPOINT ["java", "-jar", "/TaskManager/TaskManager.jar"]