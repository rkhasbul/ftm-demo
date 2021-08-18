FROM registry.redhat.io/ubi8/openjdk-11

WORKDIR /app

COPY target/ftm-demo-*.jar /app/ftm-demo.jar

CMD ["java", "-jar", "/app/ftm-demo.jar"]