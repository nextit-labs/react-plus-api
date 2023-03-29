FROM appinair/jdk17-maven

COPY target/reactplus-api-0.0.1-SNAPSHOT.jar api.jar

ENTRYPOINT ["java","-jar","/api.jar"]