# Use a base image with OpenJDK pre-installed
FROM openjdk:17-alpine

# Set the working directory in the container
WORKDIR /opt

ENV PORT 8761

# Expose port 8080 to the outside world
EXPOSE 8761

# Copy the packaged JAR file into the container
COPY target/*.jar /opt/eureka-server-0.0.1-SNAPSHOT.jar


# Command to run the Spring Boot application
CMD ["java", "-jar", "eureka-server-0.0.1-SNAPSHOT.jar"]
