FROM openjdk:17-ea-jdk-slim
ARG JAR_FILE=build/libs/realWriting-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} realWriting-server.jar
ENTRYPOINT ["java", "-jar", "/realWriting-server.jar"]