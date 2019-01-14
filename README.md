# home-work-log
Home Work Application

1) Add/Update/Delete home works. Used hibernate and JPA Repository to save, update and retrieve homeworks.
2) Connecting to other quotes microservices using feign client
3) Used Eureka naming server to registry multiple microservices which helps during scaling the of instances
4) Used swagger for API documentation and hateoas to provide links to other APIs in the response
5) Setup Zuul API gateway

Applications & Ports:
| Application             | Port  |
|-------------------------|-------|
| Home Work Application   | 8080  |
| Ron Swanson Application | 9000  |
| Eureka                  | 8761  |
| API Gateway             | 8888  |
