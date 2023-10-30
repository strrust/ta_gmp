# TA GMP
This repository contains homework tasks for TA GMP.

## Essentials

* java 17;

* Apache Maven.

## How to launch API tests

* Clone the project to your local machine

* Run ReportPortal locally with Docker, generate demo data and API key

* Follow instructions from src/main/resources/env/local.properties.template

* To run api-tests, use command:

> mvn clean test -pl api-tests -DTA_ENV=local -DlogLevel=INFO -DAUTH_TOKEN={RP_API_key}

* To run ui-tests, use command:

> mvn clean test -pl ui-tests -DTA_ENV=local -DlogLevel=INFO
