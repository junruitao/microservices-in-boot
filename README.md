#Voyager CoffeeShop system

## Catalog Service

This application is part of the Voyager CoffeeShop system and provides the functionality for managing
the products in the CoffeeShop catalog. 

http://localhost:9001/
http://localhost:9001/products/
http://localhost:9001/products/Espresso/Big



## REST API

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

## Useful Commands

| Gradle Command	         | Description                                   |
|:---------------------------|:----------------------------------------------|
| `./gradlew clean`        | Clean  application.                          |:----------------------------------------------|
| `./gradlew bootRun`        | Run the application.                          |
| `./gradlew build`          | Build the application.                        |
| `./gradlew test`           | Run tests.                                    |
| `./gradlew bootJar`        | Package the application as a JAR.             |
| `./gradlew bootBuildImage` | Package the application as a container image. |


## Config Service

## Order Service

## Edge Service
http://localhost:9001/orders
http://localhost:9001/products/

## docker compose
```
    docker compose up
```

## Tilt

To run in Kubernetes, run `tilt` after `create-cluster`
```
tilt up
```