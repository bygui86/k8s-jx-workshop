
FROM openjdk:8-jre-alpine

ADD target/ /opt/
WORKDIR /opt

EXPOSE 8080

ENTRYPOINT exec java $JAVA_OPTS -jar consumer-service.jar
