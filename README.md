# Enterprise Warehouse Management System (WMS)

## Architectural Directives and Technology Stack

| Component | Technology | Architectural Rationale |
|-----------|------------|--------------------------|
| Backend Framework | Java 17, Spring Boot 3.x | Develops scalable and production-ready REST APIs for warehouse operations. |
| Data Access Layer | Spring Data JPA / Hibernate | Handles database operations using ORM with secure and efficient queries. |
| Primary Database | PostgreSQL | Stores inventory, warehouse, and order data while ensuring transactional integrity. |
| Security | Spring Security, JWT | Secures REST APIs with authentication and role-based authorization. |
| Barcode Integration | ZXing | Generates Barcode/QR codes for product identification and inventory tracking. |
| API Documentation | Swagger (Springdoc OpenAPI) | Provides interactive documentation and API testing. |
| Testing | JUnit 5, Mockito | Unit testing for services and business logic. |
| Build Tool | Maven | Dependency management and project build automation. |
| Version Control | Git & GitHub | Source code version control and collaboration. |
| Frontend | React.js *(Future Scope)* | The current implementation focuses on the backend REST APIs. A React frontend can be integrated in the future. |

## System Architecture

```
                 Client
        (Swagger UI / Postman)
                   |
                   v
        Spring Boot REST API
                   |
   ---------------------------------
   |               |               |
   v               v               v
Controllers     Services     Security (JWT)
                   |
                   v
 Repository (Spring Data JPA)
                   |
                   v
            PostgreSQL Database
                   |
                   v
        Barcode Service (ZXing)
```
