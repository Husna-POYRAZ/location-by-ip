FROM openjdk:17

WORKDIR /app

COPY /asset /app/asset

ARG JAR_FILE=/target/*.jar

COPY ${JAR_FILE} /app/location-by-ip.jar

ENV SPRING_PROFILES_ACTIVE=prod

CMD ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "location-by-ip.jar"]

