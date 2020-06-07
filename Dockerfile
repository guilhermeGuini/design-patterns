FROM openjdk:8-jdk-alpine
COPY /app /app
RUN chmod +x /app/gradlew
RUN /app/gradlew build
ARG JAR_FILE=/app/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]