FROM tomcat:9.0.60-jdk11-openjdk

ARG WAR_FILE_NAME
ADD target/${WAR_FILE_NAME} /usr/local/tomcat/webapps/jfrog-demo.war
RUN mkdir /app/ /var/db_data/
ADD fake-creds.txt /app/top.keys_api.cfg
ADD src/main/resources/data/shows-db.json /var/db_data/shows-db.json
EXPOSE 8080
CMD ["catalina.sh", "run"]