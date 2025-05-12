FROM ubuntu:jammy-20250415.1
RUN apt-get update && apt-get install openjdk-17-jdk curl vim -y
WORKDIR /opt
ADD target/quizzapp-*.jar quizzapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "quizzapp.jar"]
