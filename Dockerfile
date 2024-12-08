FROM maven:3.4.0-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/product-catlog-backend-0.0.1-SNAPSHOT.jar product-catlog-backend.jar
EXPOSE  8080
ENTRYPOINT [ "java", "-jar", "/product-catlog-backend.jar" ]