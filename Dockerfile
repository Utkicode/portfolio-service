FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine
COPY --from=build /target/portfolio-service-0.0.1-SNAPSHOT.jar portfolio-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "portfolio-service.jar"]