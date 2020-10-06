#!/bin/sh
export MONGO_DB_USERNAME=${MONGO_DB_USERNAME:=`cat ${MONGO_DB_USERNAME_FILE}`}
export MONGO_DB_PASSWORD=${MONGO_DB_PASSWORD:=`cat ${MONGO_DB_PASSWORD_FILE}`}
java  -jar ./spring-boot-mongo.jar
