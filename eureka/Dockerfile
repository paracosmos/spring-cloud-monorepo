FROM openjdk:21-jdk-slim

WORKDIR /app

COPY build/libs/eureka-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8761
