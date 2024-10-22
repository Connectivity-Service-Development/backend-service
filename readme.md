# Connectivity Service Backend

Hosted on Github: https://github.com/Connectivity-Service-Development/backend-service

## Project setup

### Localhost

Postgres is required. Run app with profile name `local`. Configure DB per `resources/application-local.properties`

### Tests

Test containers is used for test profile, **Docker** is required.

## Swagger-ui

[/swagger/swagger-ui/index.htm]()

## CI/CD

Pipeline is triggered manually. It builds docker image and pushes it to Digital Ocean container registry.

The app is deployed using App Platform. When docker image is updated, it is automatically deployed.

https://cloud.digitalocean.com/apps/68f5b2b2-f3b1-4a89-89be-557184ad6676?i=55ae0c

## DEV DEPLOYMENT

https://backend-service-7snj9.ondigitalocean.app/actuator/info
