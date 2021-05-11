# UrbanClapApp
 Order and get services


**Overview**

Tools : Spring Boot STS, POSTMAN, Docker

Technologies/Language : Java, Microservices Architecture, Eureka, Spring Boot, REST APIs

Total Applications : 
-	Login – used for logging into the application
-	Service-catalog – shows up all the available services on which requests can be made
-	Order – used to order for a particular service
-	Admin – used by admin to direct requests to service providers
-	Service-provider – used by service provider to respond to the order notifications
-	Discovery-server – Eureka to register and discover services

![image](https://user-images.githubusercontent.com/49527339/117760664-ad00dd00-b243-11eb-8276-7b6c9469ecd1.png)
![image](https://user-images.githubusercontent.com/49527339/117761284-b76fa680-b244-11eb-8bcb-4e438a4d33cd.png)


**Interservice communication approach :** 
Communication among microservices is done via rest template.
Rest template receives URL of the target microservice. All the URLs are stored in constant package in each microservice to ease the future change in respective URLs.

**ASSUMPTIONS :**
1.	It is assumed that only one service provider accepts the request and sends notification with the state-accept. Once one service provider accepts request, the request has to made unavailable for other service providers.
2.	JWT based login is performed on login application. Currently it is for User only. For admin, it is assumed that admin is already login and request is forwarded to admin as soon as order is placed via rest template.
3.	There is only request made at a time by users which is being processed throughout applications.
