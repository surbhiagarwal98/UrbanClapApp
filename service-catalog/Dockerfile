FROM openjdk:8
EXPOSE 8081
ADD target/spring-catalog-docker.jar spring-catalog-docker.jar
ENTRYPOINT ["java","-jar","/spring-catalog-docker.jar"]