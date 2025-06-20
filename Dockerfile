FROM openjdk:21
WORKDIR /app
COPY target/Eventra-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Eventra-0.0.1-SNAPSHOT.jar"]