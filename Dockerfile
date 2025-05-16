
FROM amazoncorretto:23-alpine-jdk
COPY target/LlamaPayTf-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/app.jar"]