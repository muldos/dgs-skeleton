ARG RT_REPO_PREFIX
FROM adoptopenjdk:11-jre-hotspot

RUN mkdir /opt/app
RUN mkdir /var/db_data
RUN mkdir /app/
ADD fake-creds.txt /app/top.keys_api.cfg
ARG JAR_FILE_NAME
ADD target/${JAR_FILE_NAME} /opt/app/japp.jar
EXPOSE 8080 8443

ENTRYPOINT ["java", "-jar", "/opt/app/japp.jar"]
