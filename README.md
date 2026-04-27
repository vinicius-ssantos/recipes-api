# Recipes API

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?style=for-the-badge&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=for-the-badge&logo=jsonwebtokens)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)

Backend API for a recipe sharing application, built with Java 17, Spring Boot, Spring Security, JWT authentication and MySQL.

This project is part of a full stack recipe sharing study, with the backend responsible for user authentication and recipe management.

---

## Features

- User signup
- User signin
- JWT-based authentication
- Create recipes
- List all recipes
- Update recipes
- Delete recipes
- Like recipes
- Relationship between users and recipes

---

## Tech stack

- Java 17
- Spring Boot 3.2.0
- Spring Web
- Spring Data JPA
- Spring Security
- JWT
- MySQL
- Maven
- Lombok
- Bean Validation
- JUnit / Spring Security Test

---

## Architecture overview

The project follows a common layered backend structure:

```txt
Controller -> Service -> Repository -> Database
```

Main packages:

```txt
src/main/java/com/viniciussantos
├── config
├── controller
├── model
├── repository
├── request
├── response
└── service
```

---

## Main endpoints

### Authentication

| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth/signup` | Creates a new user and returns a JWT |
| POST | `/auth/signin` | Authenticates an existing user and returns a JWT |

### Recipes

| Method | Endpoint | Description | Auth |
|---|---|---|---|
| POST | `/api/recipe` | Creates a recipe | Required |
| GET | `/api/recipe` | Lists all recipes | Not required |
| PUT | `/api/recipe/{id}` | Updates a recipe | Not required in current implementation |
| DELETE | `/api/recipe/{recipeId}` | Deletes a recipe | Not required in current implementation |
| PUT | `/api/recipe/{id}/like` | Likes a recipe | Required |

---

## Request examples

### Signup

```http
POST /auth/signup
Content-Type: application/json
```

```json
{
  "fullName": "Vinicius Santos",
  "email": "vinicius@email.com",
  "password": "123456"
}
```

### Signin

```http
POST /auth/signin
Content-Type: application/json
```

```json
{
  "email": "vinicius@email.com",
  "password": "123456"
}
```

### Create recipe

```http
POST /api/recipe
Authorization: Bearer <jwt-token>
Content-Type: application/json
```

```json
{
  "title": "Chocolate Cake",
  "description": "Simple homemade chocolate cake",
  "image": "https://example.com/cake.png"
}
```

---

## Running locally

### Requirements

- Java 17+
- Maven
- MySQL

### Database

Create a MySQL database:

```sql
CREATE DATABASE recipe_sharing;
```

Default configuration:

```properties
server.port=5454
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/recipe_sharing
spring.datasource.username=viniciussantos
spring.datasource.password=user_password
```

You can change these values in:

```txt
src/main/resources/application.properties
```

### Start the application

```bash
mvn spring-boot:run
```

The API will be available at:

```txt
http://localhost:5454
```

---

## Running tests

```bash
mvn test
```

---

## Related project

- [recipes-app](https://github.com/vinicius-ssantos/recipes-app) - frontend application built with Angular.

---

## Next improvements

- Add Swagger/OpenAPI documentation
- Add Docker Compose for MySQL and application startup
- Improve authorization rules for update and delete operations
- Add more unit and integration tests
- Add CI pipeline with GitHub Actions
