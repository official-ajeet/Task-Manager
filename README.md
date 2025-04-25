# Task Manager (Spring Boot)

This is a simple RESTful Task Manager backend built using **Java Spring Boot**, created as part of a backend developer assessment. It supports:

- User registration and login
- Token-based session management (in-memory)
- Add, view, and delete tasks (user-specific)
- In-memory data handling (no external database used)

---

## 📦 Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Lombok
- In-Memory Storage (via HashMap)
- Postman for testing

---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/task-manager.git
   cd task-manager


---

```markdown
## 🧪 API Endpoints

### 🔐 Authentication

#### `POST /api/user/register`

**Request Body:**
```json
{
  "username": "user",
  "password": "1234"
}
```

#### `POST /api/user/login`

**Response:**
```json
{
  "token": "<your-token>"
}
```

---

### 📋 Task Management

> **Include token in request header:**
> ```
> Authorization: Bearer <your-token>
> ```

#### `POST /api/task/add`

**Request Body:**
```json
{
  "title": "Learn Spring Boot"
}
```

#### `GET /api/task/view`

Fetches all tasks for the logged-in user.

#### `DELETE /api/task/delete/{taskId}`

Deletes the task with the given `taskId`.
```

---

Let me know if you'd like to include curl examples or a sample Postman collection as well!
