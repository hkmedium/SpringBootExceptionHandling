**Spring Boot REST API Global Exception Handling**

**Dependencies:**
1. Spring Web
2. Lombok
3. Sprint Data JPA
4. My SQL Driver
5. Spring Boot DevTools

Language: Java

Project: Maven

Spring Boot: 3.3.3

Java Version: 17


**Create User Endpoint:**
POST: http://localhost:8086/api/users
Payload: {"email":"is@gmail.com","password":"is123"}

**Get all users Endpoint:**
GET: http://localhost:8086/api/users

**Get a User by Id Endpoint:**
GET: http://localhost:8086/api/users/1

Please see **UserService.class** class where specific Exception are handled.  
