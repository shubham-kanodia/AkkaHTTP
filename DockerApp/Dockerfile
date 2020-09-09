FROM java:8

WORKDIR /root

EXPOSE 8080

ADD ["AkkaHTTP/target/scala-2.11/Akka HTTP-assembly-1.0.jar", "/root/AkkaWebApp.jar"]

CMD java -jar AkkaWebApp.jar
