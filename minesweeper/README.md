Minesweeper App Engine
======================

## Setup

* Download and initialize the [Cloud SDK](https://cloud.google.com/sdk/)

    `gcloud init`

* Create an App Engine app within the current Google Cloud Project

    `gcloud app create`

## Maven
### Running locally

`mvn appengine:run`

To use vist: http://localhost:8080/

### Deploying

`mvn appengine:deploy`

To use visit:  https://YOUR-PROJECT-ID.appspot.com

For this project the URL is: https://deviget-minesweeper.appspot.com

## Testing

`mvn verify`

### Out of memory errors

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
