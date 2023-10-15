# TA GMP
This repository contains tasks for TA GMP.

## Essentials

* java 17;

* Apache Maven.

## How to launch API tests

* Clone the project to your local machine

* Run ReportPortal locally with Docker and generate API key

* To run all api-tests, use command:

> mvn clean test -pl api-tests -DTA_ENV=local -DlogLevel=INFO -DAUTH_TOKEN={RP_API_key}
>

* To run all ui-tests, use command:

> mvn clean test -pl ui-tests -DTA_ENV=local -DlogLevel=INFO