FROM amazoncorretto:21
COPY LlamaPayTf-0.0.1-SNAPSHOT.jar /app/LlamaPayTf-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/LlamaPayTf-0.0.1-SNAPSHOT.jar"]
