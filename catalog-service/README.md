# Catalog Service

This application is part of the Voyager CoffeeShop system and provides the functionality for managing
the products in the CoffeeShop catalog. It's part of the project built in the
[Cloud Native Spring in Action](https://www.manning.com/products/cloud-native-spring-in-action) product
by [Thomas Vitale](https://www.thomasvitale.com).

## REST API

| Endpoint	      | Method   | Req. body  | Status | Resp. body     | Description    		   	     |
|:---------------:|:--------:|:----------:|:------:|:--------------:|:-------------------------------|
| `/products`        | `GET`    |            | 200    | Product[]         | Get all the products in the catalog. |
| `/products`        | `POST`   | Product      | 201    | Product          | Add a new product to the catalog. |
|                 |          |            | 422    |                | A product with the same ISBN already exists. |
| `/products/{isbn}` | `GET`    |            | 200    | Product          | Get the product with the given ISBN. |
|                 |          |            | 404    |                | No product with the given ISBN exists. |
| `/products/{isbn}` | `PUT`    | Product      | 200    | Product          | Update the product with the given ISBN. |
|                 |          |            | 200    | Product          | Create a product with the given ISBN. |
| `/products/{isbn}` | `DELETE` |            | 204    |                | Delete the product with the given ISBN. |

## Useful Commands

| Gradle Command	         | Description                                   |
|:---------------------------|:----------------------------------------------|
| `./gradlew bootRun`        | Run the application.                          |
| `./gradlew build`          | Build the application.                        |
| `./gradlew test`           | Run tests.                                    |
| `./gradlew bootJar`        | Package the application as a JAR.             |
| `./gradlew bootBuildImage` | Package the application as a container image. |

After building the application, you can also run it from the Java CLI:

```bash
java -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar
```
