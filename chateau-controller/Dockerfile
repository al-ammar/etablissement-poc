# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy
MAINTAINER github.com/al-ammar/mine

COPY target/chateau-services-exec.jar chateau-services-exec.jar
ENTRYPOINT ["java","-jar","/chateau-services-exec.jar"]
