# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot 3.5.6 reactive web application using WebFlux and R2DBC for non-blocking database operations with PostgreSQL.

**Technology Stack:**
- Java 25
- Spring Boot 3.5.6
- Spring WebFlux (reactive web framework)
- Spring Data R2DBC (reactive database access)
- PostgreSQL with R2DBC driver
- Project Lombok (annotation processing)
- Spring Validation

## Build and Development Commands

**Build the project:**
```bash
./mvnw clean install
```

**Run the application:**
```bash
./mvnw spring-boot:run
```

**Run tests:**
```bash
./mvnw test
```

**Run a single test class:**
```bash
./mvnw test -Dtest=ClassName
```

**Run a single test method:**
```bash
./mvnw test -Dtest=ClassName#methodName
```

**Package the application:**
```bash
./mvnw package
```

## Architecture

This is a reactive application built on Spring WebFlux with R2DBC for non-blocking database operations.

**Reactive Programming Model:**
- All operations should return `Mono<T>` (single value) or `Flux<T>` (stream of values)
- Database operations use R2DBC drivers for non-blocking PostgreSQL access
- REST endpoints should be built with reactive router functions or annotated controllers returning reactive types

**Key Dependencies:**
- `spring-boot-starter-webflux`: Reactive web framework using Reactor
- `spring-boot-starter-data-r2dbc`: Reactive database access layer
- `r2dbc-postgresql`: PostgreSQL driver for R2DBC
- `reactor-test`: Testing utilities for reactive streams

**Project Structure:**
- Base package: `com.example.webfluxtutorial`
- Configuration: `src/main/resources/application.properties`
- DevTools enabled for hot reload during development

**Lombok Configuration:**
- Lombok annotation processing is configured in the Maven compiler plugin
- Lombok is excluded from the final artifact