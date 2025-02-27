# Stage 1: Use Maven for building
FROM maven:3.8.5-openjdk-17-slim as build
WORKDIR /app
COPY ./discoverServer ./discoverServer
WORKDIR /app/discoverServer
RUN mvn clean package

# Stage 2: Use openJdk for running
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/discoverServer/target/*.jar discoverServer.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","discoverServer.jar"]