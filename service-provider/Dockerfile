FROM openjdk:8
EXPOSE 8084
ADD target/spring-service-provider-docker.jar spring-service-provider-docker.jar
ENTRYPOINT ["java","-jar","/spring-service-provider-docker.jar"]