# Use the official OpenJDK image as a base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/your-spring-boot-app.jar /app/your-spring-boot-app.jar

# Expose the port the app runs on
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "your-spring-boot-app.jar"]
