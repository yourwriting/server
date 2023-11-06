FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/realWriting-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /yourwriting.jar

ENTRYPOINT ["java", "-jar", "/yourwriting.jar"]