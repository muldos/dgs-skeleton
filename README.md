# DGS (from Netflix) skeleton project

## Introduction

Run the project : 
Set 2 env var
SHOWS_JSONDB_FOLDER (example : /Path/to/dgs-skeleton/src/main/resources/data)
and
SAMPLE_ENDPOINT_URL (example: http://foo-bar.com)
then run 
```
mvn spring-boot:run
```

This project is also using the dockerfile-maven-plugin from Spotify to automatically build and push a docker image with a single mvn deploy.

To push on the the wanted docker repository add the following to your `settings.xml`

```xml
	<servers>
		<server>
			<id>drobin.jfrog.io/myswamp/</id><!-- change this of course-->
			<username>your_username</username>
			<password>your_password</password>
		</server>
	</servers>
```

## Build & run
Be sure that docker daemon is running.
```
mvn deploy
docker run -p 8080:8080 -e SAMPLE_ENDPOINT_URL=https://foobar.com/unused -v /path/to/db-json:/var/db_data -d drobin.jfrog.io/myswamp/dgs-skeleton
```

Then browse to http://localhost:8080/graphiql

### references

- https://netflix.github.io/dgs/
- https://github.com/spotify/dockerfile-maven
