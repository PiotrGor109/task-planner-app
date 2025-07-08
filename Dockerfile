# Etap 1: Budowanie aplikacji
#Test2Develop
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml /app
RUN mvn dependency:go-offline

COPY src /app/src
RUN mvn clean package -DskipTests

# Etap 2: Uruchamianie aplikacji
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/myapp.jar

CMD ["java", "-jar", "myapp.jar"]
