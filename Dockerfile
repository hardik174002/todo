FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean install -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar  app.jar
EXPOSE 8082
HEALTHCHECK --interval=10s --timeout=5s --start-period=20s  CMD curl -f http://localhost:8082/actuator/health || exit 1
ENTRYPOINT ["java","-jar","app.jar"]

