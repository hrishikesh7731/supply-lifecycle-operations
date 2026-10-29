# Supplier Lifecycle Operations (SLO)

A supplier lifecycle management backend that handles supplier onboarding, qualification, approval, activation, compliance and performance monitoring.

## Tech Stack

Java, Spring Boot, Spring Data JPA, Hibernate, PostgreSQL, Spring Security, JWT, Maven

## Features

- RESTful APIs for supplier registration, profile management, document submission and supplier lifecycle operations
- DTO-based request handling, entity transformation and JPA persistence for supplier and company information
- Supplier verification and approval workflows with controlled status transitions and role-based access (Spring Security and JWT)
- Document tracking, compliance monitoring, supplier performance records and periodic review workflows
- Integration with shared company management and notification services for supplier administrator creation and lifecycle communications
- Centralized exception handling, input validation, automated tests and API documentation

## Getting Started

### Prerequisites

- Java 17
- PostgreSQL
- Maven (or use the included Maven wrapper)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/hrishikesh7731/supply-lifecycle-operations.git
   cd supply-lifecycle-operations
   ```
2. Create a PostgreSQL database named `supply-chain-easy-db`.
3. Set the database URL, username and password in `src/main/resources/application.properties`.
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
5. The API starts at `http://localhost:8080`.

### Run the tests

```bash
./mvnw test
```

## Author

Gaddamedi Hrishikesh | [LinkedIn](https://www.linkedin.com/in/hrishikesh-gaddamedi-6b0a513b0/) | [GitHub](https://github.com/hrishikesh7731)
