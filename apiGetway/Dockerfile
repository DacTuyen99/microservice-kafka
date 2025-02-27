# Stage 1: Use Maven for building
FROM maven:3.8.5-openjdk-17-slim as build
WORKDIR /app
COPY ./apiGetway ./apiGetway
WORKDIR /app/apiGetway
RUN mvn clean package

# Stage 2: Use openJDK for running
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/apiGetway/target/*.jar apiGetway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "apiGetway.jar"]