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

