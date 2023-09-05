# Demo Service for Authentication and Security with Spring Boot

## Technologies
* Spring Boot 3
* Spring Security 6
* JWT
* PostgreSQL
* Swagger
* Lombok

## Configuration
To run this application in local environment you need to create an ***application-local.properties*** and set a similar content of ***application-example.properties*** with your database parameters and additional preferences. To run this application in production create a new file of spring boot properties set the neccesary configuration and change the environment with runs this app.

For change the environment you can use ***spring.profiles.active=name-of-your-environment*** in ***application.properties*** file or use the command: 

>`mvn spring-boot:run -Dspring.config.name=application-develop` 

or for generate the jar file: 

>`java -jar -Dspring.config.name=application-develop demo-auth-security-ws.jar`

## Conventions
### Database
Database conventions: 
### Versioning
For create commits we follow the conventions specified in [Convetional Commits](https://www.conventionalcommits.org/en/v1.0.0/).
