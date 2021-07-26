FROM adoptopenjdk:11-jre-hotspot

RUN mkdir /opt/app
ARG JAR_FILE
ADD target/${JAR_FILE} /opt/app/japp.jar
EXPOSE 8080 8443

CMD ["java", "-jar", "/opt/app/japp.jar"]