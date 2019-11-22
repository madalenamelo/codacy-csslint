FROM openjdk:8-jre-alpine

RUN apk update && apk add bash && apk add nodejs-current-npm && npm install -g csslint@1.0.5
