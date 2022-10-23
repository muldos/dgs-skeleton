# DGS (from Netflix) skeleton project

[![github-dgs-build](https://github.com/muldos/dgs-skeleton/actions/workflows/workflow.yml/badge.svg)](https://github.com/muldos/dgs-skeleton/actions/workflows/workflow.yml)

## Introduction

Run the project locally (outside docker): 
Set SHOWS_JSONDB_FOLDER env var (example : /Path/to/dgs-skeleton/src/main/resources/data)
then run 
```
mvn spring-boot:run
```

## Build & run
Be sure that docker daemon is running.

```
export JAR_VERSION=1.2.3
mvn clean package
docker build --build-arg JAR_FILE_NAME=dgs-skeleton-$JAR_VERSION.jar -t dgs-graphql:latest .
docker run -p 8080:8080 -v ./src/main/resources/data:/var/db_data -d --name graphql-demo dgs-graphql:latest
```

Then browse to http://localhost:8080/graphiql

### references

- https://netflix.github.io/dgs/

