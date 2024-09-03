# Use a base image with OpenJDK 17
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/auth-service-0.0.1-SNAPSHOT.jar auth-service.jar

# Expose the port the service runs on
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "auth-service.jar"]