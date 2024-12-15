FROM openjdk:21-jdk

WORKDIR /app

COPY target/CICDResrch-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]