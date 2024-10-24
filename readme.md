# Connectivity Service Backend

[Hosted on GitHub](https://github.com/Connectivity-Service-Development/backend-service)

Request access [email](mailto:davgustis@gem.cz)

## Local build

**Docker** and **Java 21** are required.

`./gradlew clean buld`

## Local Run

Postgres is required. Run app with profile name `local`. Configure DB
per [application-local.properties](src/main/resources/application-local.properties)

One command setup using docker:

`docker run -d \
  --name connectivity-postgres \
  -e POSTGRES_DB=connectivity \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=mysecretpassword \
  -p 5432:5432 \
  postgres:16`

Run using Gradle:

`./gradlew bootRun --args='--spring.profiles.active=local'`

To test go to:

http://localhost:8080/swagger/swagger-ui/index.html

## Tests and documentation

Each use case is covered by integration tests. App uses `test containers`, **Docker** is required.

Tests also serve a purpose for developers as documentation. Can be used to guide through the application logic.

## API Documentation

Api spec is described using OpenAPI:
https://backend-service-7snj9.ondigitalocean.app/swagger/swagger-ui/index.html

## CI/CD

[GitHub Actions](https://github.com/Connectivity-Service-Development/backend-service/actions)

### Dev

Pipeline is triggered either manually or automatically on push to develop branch.

It builds docker image and pushes it to Digital Ocean container registry.

The app is deployed using App Platform. When docker image is updated, it is automatically deployed.

https://cloud.digitalocean.com/apps/68f5b2b2-f3b1-4a89-89be-557184ad6676?i=55ae0c

### Prod

Pipeline is triggered automatically on git tag.

It builds docker image and pushes it to Digital Ocean production container registry.

The app is deployed using App Platform. When docker image is updated, it is automatically deployed.

## DEV DEPLOYMENT

https://backend-service-7snj9.ondigitalocean.app/actuator/info
