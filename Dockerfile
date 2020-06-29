FROM tomcat:9.0.24
VOLUME /tmp
COPY target/rentservice-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/app.war
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/app.war" ]