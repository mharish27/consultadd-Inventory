# Inventory Management API

This is a simple Spring Boot application for managing inventory items, connected to a MySQL database.

---

## API Documentation

| Method | Endpoint | Description | Request Body / Parameters | Response |
| :--- | :--- | :--- | :--- | :--- |
| GET | `/items` | Fetch all items | None | List of `Item` |
| GET | `/items/{id}` | Fetch a single item by ID | Path Variable: `id` | Single `Item` object |
| POST | `/items` | Create a new item | JSON body: `{ "name": "...", "quantity": ..., "price": ... }` | Created `Item` |
| PUT | `/items/{id}/quantity?quantity=value` | Update quantity of an item | Path Variable: `id`, Query Param: `quantity` | Updated `Item` |
| DELETE | `/items/{id}` | Delete an item by ID | Path Variable: `id` | 204 No Content |

---

## 📄 Setup Instructions

### 1. Prerequisites
- Java 17+ installed
- Maven installed
- MySQL server running
- MySQL Workbench (optional, for DB visualization)

### 2. Clone the Repository
```bash
git clone git@github.com:your-username/your-repo-name.git
cd your-repo-name
```

### 3. Configure the Database

- Create a new database in MySQL:
```sql
CREATE DATABASE inventorydb;
```

- Update the database configuration in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventorydb
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

### 4. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

The application will start at:  
> http://localhost:8080/

---

## Usage Examples

### ➡️ Create a New Item

**Request:**
```bash
POST http://localhost:8080/items
Content-Type: application/json
```
**Body:**
```json
{
  "name": "Laptop",
  "quantity": 10,
  "price": 1200.50
}
```

**Response:**
```json
{
  "id": 1,
  "name": "Laptop",
  "quantity": 10,
  "price": 1200.5
}
```

---

### ➡️ Get All Items

**Request:**
```bash
GET http://localhost:8080/items
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "quantity": 10,
    "price": 1200.5
  },
  {
    "id": 2,
    "name": "Phone",
    "quantity": 20,
    "price": 799.99
  }
]
```

---

### ➡️ Get Item by ID

**Request:**
```bash
GET http://localhost:8080/items/1
```

**Response:**
```json
{
  "id": 1,
  "name": "Laptop",
  "quantity": 10,
  "price": 1200.5
}
```

---

### ➡️ Update Item Quantity

**Request:**
```bash
PUT http://localhost:8080/items/1/quantity?quantity=5
```

**Response:**
```json
{
  "id": 1,
  "name": "Laptop",
  "quantity": 5,
  "price": 1200.5
}
```

---

### ➡️ Delete an Item

**Request:**
```bash
DELETE http://localhost:8080/items/1
```

**Response:**
```text
204 No Content
```

---
