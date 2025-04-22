# 🛡️ Auth Service - P2P Chat App

This is the authentication microservice for the P2P Chat application. It handles user registration, login, and JWT-based authentication using **Spring WebFlux** and **Reactive MongoDB**.

---

## 🚀 Features

- ✅ Register new users with hashed passwords
- ✅ Login with username and password
- ✅ JWT token generation and validation
- ✅ Built using Spring WebFlux (reactive)
- ✅ Stateless and secure

---

## 🧰 Tech Stack

- **Spring Boot 3**
- **Spring WebFlux**
- **Spring Security**
- **Reactive MongoDB**
- **Lombok**
- **JJWT**

---

## 📦 API Endpoints

| Method | Endpoint           | Description                |
|--------|--------------------|----------------------------|
| POST   | `/auth/register`   | Register new user          |
| POST   | `/auth/login`      | Authenticate and get token |

### 📝 Sample Register Request

```json
POST /auth/register
{
  "username": "ayush",
  "password": "123456"
}
```

### 📝 Sample Login Request

```json
POST /auth/login
{
  "username": "ayush",
  "password": "123456"
}

Response
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
### 🔐 JWT Token Format
- Token is returned in response on successful login
- Include it in the Authorization header when calling protected endpoints:

```makefile
Authorization: Bearer <token>
```

### 🛠️ Running Locally

- Make sure MongoDB is running (can use Docker)
- Start the service

```bash
./mvnw spring-boot:run
```

### 🤝 Integration
- This service is consumed by user-service, chat-service, and any frontend clients.
- All other services should validate JWT tokens issued by this service.


