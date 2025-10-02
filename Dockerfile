
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/OTP1_inclass_assignment-1.0-SNAPSHOT.jar app.jar

# Command to run the application
CMD ["java", "-jar", "app.jar"]
