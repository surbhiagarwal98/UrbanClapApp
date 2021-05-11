FROM openjdk:8
EXPOSE 8082
ADD target/spring-order-docker.jar spring-order-docker.jar
ENTRYPOINT ["java","-jar","/spring-order-docker.jar"]