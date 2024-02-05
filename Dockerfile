FROM eclipse-temurin:17-jre-ubi9-minimal
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
#ARG MYSQL_HOST
#ARG MYSQL_PORT
#ARG MYSQL_DATABASE
#ARG MYSQL_USER
#ARG MYSQL_PASSWORD
ENV MYSQL_HOST=localhost
ENV MYSQL_PORT=3306
ENV MYSQL_DATABASE=treble_db
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=Password1
CMD ["java","-jar","app.jar"]