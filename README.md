# Voyager Coffee Shop System
![Preview](https://github.com/junruitao/microservices-in-boot/blob/master/background.png)
This system demostrates following cloud native usage:
* Centralized configuration management with `Spring Cloud Config Server`
* Reactive servers with Spring WebFlux and `Spring Data R2DBC`
* Edge servers and `Spring Cloud Gateway`
* Fault tolerance with `Spring Cloud Circuit Breaker` and Resilience4J
* Request rate limiting with `Spring Cloud Gateway` and `Redis`
* Managing external access with `Kubernetes Ingress`
* Managing containers with `Docker Compose`
* Local Kubernetes development with `Tilt`

The system run following containers/services:
* postgres
* redis
* config-service
* edge-service
* order-service
* catalog-service

## Catalog Service

This application is part of the Voyager CoffeeShop system and provides the functionality for managing
the products in the CoffeeShop catalog. 



### REST API

| Endpoint	      | Method   | Req. body  | Status | Resp. body     | Description    		   	     |
|:---------------:|:--------:|:----------:|:------:|:--------------:|:-------------------------------|
| `/products`        | `GET`    |            | 200    | Product[]         | Get all the products in the catalog. |
| `/products`        | `POST`   | Product      | 201    | Product          | Add a new product to the catalog. |
|                 |          |            | 422    |                | A product with the same ISBN already exists. |
| `/products/{category}/{size}` | `GET`    |            | 200    | Product          | Get the product with the given Category & Size. |
|                 |          |            | 404    |                | No product with the given ISBN exists. |
| `/products/{category}/{size}` | `PUT`    | Product      | 200    | Product          | Update the product with the given Category & Size. |
|                 |          |            | 200    | Product          | Create a product with the given ISBN. |
| `/products/{category}/{size}` | `DELETE` |            | 204    |                | Delete the product with the given Category & Size. |



## Config Service
http://localhost:8888/config-service/product

## Order Service
http://localhost:9002/orders

## Edge Service
http://localhost:9000/orders
http://localhost:9000/products/

## docker compose
```
    docker compose up
```

## Tilt

To run in Kubernetes, run `tilt` after `create-cluster`
```
tilt up
```

## Useful Commands

| Gradle Command	         | Description                                   |
|:---------------------------|:----------------------------------------------|
| `./gradlew clean`        | Clean  application.                          |:----------------------------------------------|
| `./gradlew bootRun`        | Run the application.                          |
| `./gradlew build`          | Build the application.                        |
| `./gradlew test`           | Run tests.                                    |
| `./gradlew bootJar`        | Package the application as a JAR.             |
| `./gradlew bootBuildImage` | Package the application as a container image. |
