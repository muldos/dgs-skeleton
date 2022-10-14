ARG RT_REPO_PREFIX
FROM adoptopenjdk:11-jre-hotspot

RUN mkdir /opt/app
RUN mkdir /var/db_data
ARG JAR_FILE_NAME
ADD target/${JAR_FILE_NAME} /opt/app/japp.jar
EXPOSE 8080 8443

ENTRYPOINT ["java", "-jar", "/opt/app/japp.jar"]
