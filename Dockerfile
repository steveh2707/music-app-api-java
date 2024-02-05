FROM eclipse-temurin:17-jre-ubi9-minimal
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT["java", "-jar", "app/app.jar"]