FROM alexeysidorov/debian-liberica11:1.0.1
ARG JAR_FILE=target/person-server.jar
COPY ${JAR_FILE} person-server.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/person-server.jar"]
