Minesweeper App Engine
======================

## Development decisions

1. Selected SpringBoot + Appengine as stack 
2. Used Google Appengine starter kit to base of project
3. Defined only 2 domain entities Game and Cell
4. Implemented in-memory persistence with H2
5. Ability to select the size of the board, then rows and colums are equals
6. Added BoardApi, CellApi and GameConfigApi as API objects to interact with outside systems, in order to don't expose the internal satructure of the domain
7. Document the API using Swagger, then a client could be directly generated
8. Each game is for a player, this is multiuser, but not registered in the system
9. Stop the development after spent 6 hours
10. Generate API client for Javascript using swagger-codegen-cli tool

### Missing implementation

- Implement an API client library for the API designed above. Ideally, in a different language, of your preference, to the one used for the API
- When a cell with no adjacent mines is revealed, all adjacent squares will be revealed (and repeat)
- Detect when game is over
- Time tracking (should be control by clients and register on the system)
- Ability to choose number of mines

### Known issues

The initial implementation has no take in account boundary cases. Then this first presentation only happy paths are working as expected.

## Generate client with Swagger

As the project is using Swagger then we can automate the client generation.

I used the swagger-codegen-cli (https://github.com/swagger-api/swagger-codegen) to generate a Javascript Client project

To generate the code I used the next command:
```
java -jar swagger-codegen-cli-2.2.3.jar generate \
  -i http://deviget-minesweeper.appspot.com/v2/api-docs \
  -l javascript \
  -o src/clients/javascript
```

I versioned the generated code just as example

## Testing Environment

### Main URL
  http://deviget-minesweeper.appspot.com/

### API Document (Swagger)
  http://deviget-minesweeper.appspot.com/swagger-ui.html

## Environment Setup

* Download and initialize the [Cloud SDK](https://cloud.google.com/sdk/)

    `gcloud init`

* Create an App Engine app within the current Google Cloud Project

    `gcloud app create`

### Maven
#### Running locally

`mvn appengine:run`

To use vist: http://localhost:8080/

#### Deploying

`mvn appengine:deploy`

To use visit:  https://YOUR-PROJECT-ID.appspot.com

For this project the URL is: https://deviget-minesweeper.appspot.com

### Testing

`mvn verify`

#### Out of memory errors

With Spring Boot >= 1.5.6, you may run into out of memory errors on startup.
Please follow these instructions to work around this issue:

1. Inside src/main/resources, adding a logging.properties file with:
```ini
.level = INFO
```
2. Inside src/main/webapp/WEB-INF/appengine-web.xml, add a config that points to the new logging.properties file.
```xml
<system-properties>
  <property name="java.util.logging.config.file" value="WEB-INF/classes/logging.properties"/>
</system-properties>
```
