# Komme i gang

Hvordan bygge, teste og kjøre koden

## Forutsetninger

- Java 17
- Docker - [Last ned](https://www.docker.com/products/docker-desktop)

## Kjør lokalt

Kjør `docker-compose` for å starte RabbitMQ:

```bash
  docker-compose up
```

Kjør `mvn` for å bygge prosjektet:

```bash
  ./mvnw clean install
```

Start applikasjonen:

```bash
  ./mvnw spring-boot:run
```