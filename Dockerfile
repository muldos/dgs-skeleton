FROM tomcat:9.0.60-jdk11-openjdk

ARG WAR_FILE_NAME
ADD target/${WAR_FILE_NAME} /usr/local/tomcat/webapps/jfrog-demo.war
RUN mkdir /app/
ADD fake-creds.txt /app/top.keys_api.cfg
EXPOSE 8080
CMD ["catalina.sh", "run"]