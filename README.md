# Spring Boot CRUD API

A simple **CRUD (Create, Read, Update, Delete) REST API** built using **Spring Boot** and **Spring Data JPA**. This API allows users to be managed with basic operations like creating, retrieving, updating, and deleting users from a database.

## 🚀 Features
- RESTful API with **Spring Boot**
- CRUD operations using **Spring Data JPA**
- Database integration with **H2 (In-Memory)** or **MySQL/PostgreSQL**
- API testing with **Postman or cURL**
- Well-structured **MVC architecture**

## 🛠 Tech Stack
- **Java** (JDK 17+)
- **Spring Boot**
- **Spring Data JPA (Hibernate ORM)**
- **H2 / MySQL / PostgreSQL**
- **Postman / cURL**
- **Maven**

---

## 📥 Installation & Setup

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/ericmed1/SpringBoot-CRUD-API.git
cd SpringBoot-CRUD-API
```

### 2️⃣ Install Dependencies
```sh
mvn clean install
```

### 3️⃣ Run the Application
```sh
mvn spring-boot:run
```

The API will now be running at: **`http://localhost:8080/users`** 🎉

---

## 📌 API Endpoints

### 🔹 Get All Users
```http
GET /users
```
_Response:_
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com"
  }
]
```

### 🔹 Get User by ID
```http
GET /users/{id}
```

### 🔹 Create a New User
```http
POST /users
```
_Request Body:_
```json
{
  "name": "Jane Doe",
  "email": "jane@example.com"
}
```

### 🔹 Update an Existing User
```http
PUT /users/{id}
```
_Request Body:_
```json
{
  "name": "Updated Name",
  "email": "updated@example.com"
}
```

### 🔹 Delete a User
```http
DELETE /users/{id}
```

---

## 🛠 Configuration (Optional)
### 🔹 **Using MySQL Instead of H2**
Modify `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## 🤝 Contributing
Feel free to **fork this repository** and submit a pull request with improvements! 🙌

---

## 📜 License
This project is **open-source** and available under the **MIT License**.


