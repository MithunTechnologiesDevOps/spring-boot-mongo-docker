FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add /bin/sh

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY target/spring-boot-mongo-1.0.jar $PROJECT_HOME/spring-boot-mongo.jar
COPY initScript.sh $PROJECT_HOME/initScript.sh
WORKDIR $PROJECT_HOME

CMD ["sh","initScript.sh"]
