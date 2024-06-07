FROM openjdk:21-jdk-oracle

RUN mkdir /app
WORKDIR /app

COPY target/dangkang-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD [ "java", "-jar", "dangkang-0.0.1-SNAPSHOT.jar" ]