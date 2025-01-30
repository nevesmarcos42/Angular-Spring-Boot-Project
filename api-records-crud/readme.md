# CRUD API com Spring Boot, MySQL e Lombok

Este projeto é um exemplo de API CRUD simples desenvolvida com Spring Boot, MySQL e Lombok.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok

## Requisitos

- JDK 17 ou superior
- Maven
- MySQL

## Configuração do Banco de Dados

Crie um banco de dados no MySQL chamado `crud_db`. Atualize as credenciais do banco de dados no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crud_db
spring.datasource.username=root
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
