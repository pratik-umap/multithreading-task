# Multithreading Task

This is a Spring Boot–based project consisting of two clients and one server.
Both clients send requests to the server, which processes the requests and
stores the data in the database.

---

## 🛠 Setup Instructions

1. Download the project ZIP file
2. Extract it to a local folder
3. Open all projects (`client1`, `client2`, `server`) in your IDE
4. Configure database properties in the **server** project:

5. Run the applications in the following order:
- Server
- Client1
- Client2

---

## 🔌 Application Ports

- **Client1** → `8081`
- **Client2** → `8082`
- **Server**  → `8083`

---

## 🧪 API Testing

### Client1
http://localhost:8081/bank/transaction
### Client2
http://localhost:8082/bank/transaction


