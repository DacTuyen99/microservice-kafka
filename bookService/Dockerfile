# Stage 1: Use Maven for building
FROM maven:3.8.5-openjdk-17-slim as build
WORKDIR /app
COPY ./bookService ./bookService
COPY ./commonServer ./commonServer

WORKDIR /app/commonServer
RUN mvn clean install

WORKDIR /app/bookService
RUN mvn clean package -DskipTests

# Stage 2: Use openJdk for running
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/bookService/target/*.jar bookService.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","bookService.jar"]