# Use a base image with JDK 17 to run the application
FROM adoptopenjdk:17-jre-hotspot

# Set working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container at /app
COPY target/patient-hub.jar /app/patient-hub.jar

# Expose the port that the Spring Boot application runs on
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "patient-hub.jar"]



#Run the following command in the terminal to build the Docker image:
#docker build -t patient-hub .

#Once the Docker image is built, you can run it as a Docker container using the following command:
#docker run -d -p 8080:8080 --name patient-hub-container patient-hub



