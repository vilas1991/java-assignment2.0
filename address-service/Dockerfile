## Use a base image with OpenJDK pre-installed
FROM openjdk:17-alpine
#
# Set the working directory in the container
WORKDIR /opt

ENV PORT 8082

# Expose port 8080 to the outside world
EXPOSE 8082 9090

# Copy the packaged JAR file into the container
COPY target/*.jar /opt/address-service-0.0.1-SNAPSHOT.jar


# Command to run the Spring Boot application
CMD ["java", "-jar", "address-service-0.0.1-SNAPSHOT.jar"]

#FROM openjdk:17
#ADD target/address-service-0.0.1-SNAPSHOT.jar aaddress-service-0.0.1-SNAPSHOT.jar
#EXPOSE 8082
#ENTRYPOINT ["java", "-jar", "address-service-0.0.1-SNAPSHOT.jar"]
