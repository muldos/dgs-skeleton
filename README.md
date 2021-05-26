# DGS (from Netflix) skeleton project

## Introduction

Also using the dockerfile-maven-plugin from Spotify to automacally build and push a docker image with a single mvn deploy.

To push on the public docker hub repository add the following to your `settings.xml`

```xml
	<servers>
		<server>
			<id>docker.io</id>
			<username>your_hub_username</username>
			<password>your_hub_password</password>
		</server>
	</servers>
```

## Build & run

```
mvn deploy
docker run -p 8080:8080 -d your_hub_username/dgs-skeleton
```

Then browse to http://localhost:8080/graphiql

### references

- https://netflix.github.io/dgs/
- https://github.com/spotify/dockerfile-maven
