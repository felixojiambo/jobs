# JobApp - Spring Boot Application

## Overview

JobApp is a Spring Boot application designed to manage job listings and applications. It leverages Spring Cloud Eureka for service discovery, Spring Data JPA for database interactions, and Resilience4J for implementing circuit breaker patterns to ensure the application's resilience and fault tolerance.

## Configuration

### Application Properties

The application is configured through the `application.properties` file, which includes settings for:

- **Spring Application Name and Port**: The application is named `jobms` and runs on port `8082`.
- **Database Connection**: Uses MySQL as the database, with the connection details specified.
- **JPA and Hibernate Settings**: Configured to show SQL queries and to automatically create and drop the database schema.
- **Eureka Client**: Registers with a Eureka server running on `localhost:8761` and fetches the registry.
- **Logging**: Configured to log SQL statements and basic binder information for debugging purposes.
- **Actuator**: Exposes all endpoints and shows health details always. It also enables graceful shutdown and provides environment information.
- **Application Information**: Provides metadata about the application, including name, description, and version.
- **Zipkin Tracing**: Enables tracing for all requests.
- **Spring Cloud Config Server**: Fetches configuration from a Config Server running on `localhost:8080`.

### Resilience4J Circuit Breaker

The application includes a Resilience4J circuit breaker named `companyBreaker`, configured with:

- **Health Indicator**: Enabled to monitor the circuit breaker's status.
- **Sliding Window Size**: Set to `10` to calculate the error rate over the last 10 calls.
- **Minimum Number of Calls**: Requires at least `5` calls before the error rate can be calculated.
- **Permitted Number of Calls in Half-Open State**: Allows `3` calls when transitioning from open to half-open state.
- **Wait Duration in Open State**: Waits `10s` before transitioning from open to half-open state.
- **Failure Rate Threshold**: Opens the circuit breaker if the failure rate exceeds `50%`.
- **Automatic Transition from Open to Half-Open**: Enabled to automatically transition from open to half-open state.
- **Sliding Window Type**: Set to `count_based` for counting the number of calls.

## Running the Application

1. Ensure that the MySQL database is running and accessible at the specified URL.
2. Start the Eureka server if you're using it for service discovery.
3. Run the application using your preferred method (e.g., IDE, Maven, or Docker).

## Accessing the Application

Once the application is running, you can access it via `http://localhost:8082`. The Actuator endpoints are exposed, allowing you to monitor the application's health and other metrics.

## Contributing

Contributions to JobApp are welcome. Please follow the standard GitHub workflow: fork, branch, commit, and pull request.

## License

JobApp is licensed under the MIT License. See the `LICENSE` file for details.