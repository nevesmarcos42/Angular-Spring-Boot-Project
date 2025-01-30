# Use uma imagem base do Maven
FROM maven:3.6.3-jdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use uma imagem base do OpenJDK para executar o JAR gerado
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/crudapi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
