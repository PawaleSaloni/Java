# Use lightweight Java 24 runtime (LTS)
FROM eclipse-temurin:17-jdk
# Create working directory inside container
WORKDIR /app

# Copy the built JAR file into container
COPY target/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 9090

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]