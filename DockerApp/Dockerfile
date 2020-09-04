FROM java:8

ENV SCALA_VERSION 2.11.11
ENV SBT_VERSION 1.3.10

WORKDIR /root

EXPOSE 8080

ADD AkkaWebApp.jar /root/AkkaWebApp.jar

CMD java -jar AkkaWebApp.jar
