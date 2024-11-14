# Stage 1: Build the JAR file
FROM maven:3.8.6-openjdk-17 as builder

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21.0.3_9-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]