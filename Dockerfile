FROM tomcat:9-jdk17
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/my-app.war /usr/local/tomcat/webapps/my-app.war
EXPOSE 8080