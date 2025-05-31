## Running the Project with Docker

This project includes Docker and Docker Compose configurations for easy containerized setup and deployment.

### Requirements
- **Java Version:** Uses Eclipse Temurin JDK 17 (as specified in the Dockerfile)
- **Build Tool:** Maven Wrapper (`mvnw`) is included and used for building the project
- **Docker:** Make sure Docker and Docker Compose are installed on your system

### Environment Variables
- No required environment variables are specified in the Dockerfile or `docker-compose.yml` by default.
- If you need to provide environment variables, you can create a `.env` file and uncomment the `env_file` line in `docker-compose.yml`.

### Build and Run Instructions
1. **Build and start the application:**
   ```sh
   docker-compose up --build
   ```
   This will build the application using the multi-stage Dockerfile and start the container.

2. **Access the application:**
   - The application will be available at [http://localhost:8080](http://localhost:8080)

### Ports
- **8080:** Exposed by the container and mapped to the host (default Spring Boot port)

### Special Configuration
- The application runs as a non-root user inside the container for improved security.
- No external services (such as databases) are configured by default. If your application requires additional services, update `docker-compose.yml` accordingly.

---

*For more details on the application, see the rest of this README and the `HELP.md` file.*
