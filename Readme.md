
# Course Microservice : Spring Boot & Spring Cloud

## Requirements

- Java 11 
- Spring Boot 2
- Gradle 
- CURL
- JQ


## Services


### Config Service

https://cloud.spring.io/spring-cloud-config/reference/html/

    $ curl http://root:s3cr3t@localhost:8081/product-service/default | jq "."
    $ curl http://root:s3cr3t@localhost:8081/customer-service/default | jq "."
    $ curl http://root:s3cr3t@localhost:8081/shopping-service/default | jq "."
    $ curl http://root:s3cr3t@localhost:8081/registry-service/default | jq "."
    $ curl http://root:s3cr3t@localhost:8081/registry-service/primary | jq "."
    $ curl http://root:s3cr3t@localhost:8081/registry-service/primary/01-rest | jq "."
    $ curl http://root:s3cr3t@localhost:8081/registry-service/primary/09-eureka-cluster | jq "."
    $ curl http://root:s3cr3t@localhost:8081/registry-service/secondary | jq "."
    $ curl http://root:s3cr3t@localhost:8081/registry-service/tertiary | jq "."
    $ curl http://root:s3cr3t@localhost:8081/gateway-service/default | jq "."

### Discovery  Service (Eureka)
    
http://localhost:8099/


### hystrix 

    http://localhost:8093/hystrix

    http://localhost:8093/actuator/hystrix.stream

    https://github.com/wg/wrk

    $ wrk -t4 -c5 -d5 http://localhost:8093/invoices/1

### Microservice Product
GET

    curl -X GET http://localhost:8091/products  -H 'Accept: application/json' | jq '.'

POST

    curl  --request POST 'localhost:8091/products' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "name":"Wallabee Men'\''s Suede Shoe",
    "description":"Comfort and tendency do not have to be at odds. This suede wallabee style shoe is all you need for marathon work days. With soft suede design and stitched details, it is perfect to combine with jeans",
    "stock":4,
    "price":30,
    "category":{"id":1,"name": "shoes"}
    }'
### Microservice Customer
GET

    curl -X GET http://localhost:8092/customers    -H 'Accept: application/json' | jq '.'

POST

    curl --request POST 'localhost:8092/customers' \
    --header 'Content-Type: application/json' \
    --data-raw '
        {
            "numberID":"40408083",
            "firstName": "Luis",
            "lastName": "rodriguez",
            "email": "profesor@digitallab.academy",
            "photoUrl": "",
            "region": {
                "id": 1
            }
        }
    '

### Microservice Shopping
GET
    curl -X GET http://localhost:8093/invoices/1 -H 'Accept: application/json' | jq '.'

POST

    curl  --request POST 'localhost:8093/invoices' \
    --header 'Content-Type: application/json' \
    --data-raw '{

        "numberInvoice": "002",
        "description": "invoice store",
        "customerId": 1,
        "items": [
            {
                "quantity": 1,
                "priceItem": 178.89,
                "productId": 1
            },
    
            {
                "quantity": 2,
                "priceItem": 40.06,
                "productId": 3
            }
        ]
    }'

### Gateway Service 

Customer

    curl -X GET http://localhost:8080/customers    -H 'Accept: application/json' | jq '.'

Products

    curl -X GET http://localhost:8080/products  -H 'Accept: application/json' | jq '.'


Invoices

    curl -X GET http://localhost:8080/invoices/1 -H 'Accept: application/json' | jq '.'




### run  Eureka Cluster

    $ SPRING_PROFILES_ACTIVE=primary gradle bootRun
    $ SPRING_PROFILES_ACTIVE=secondary gradle bootRun
    $ SPRING_PROFILES_ACTIVE=tertiary gradle bootRun

### run  Multi Config
    
    $ SPRING_PROFILES_ACTIVE=primary gradle bootRun
    $ SPRING_PROFILES_ACTIVE=secondary gradle bootRun