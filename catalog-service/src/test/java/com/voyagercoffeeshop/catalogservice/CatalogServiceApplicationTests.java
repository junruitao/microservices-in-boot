package com.voyagercoffeeshop.catalogservice;

import com.voyagercoffeeshop.catalogservice.domain.Category;
import com.voyagercoffeeshop.catalogservice.domain.Product;
import com.voyagercoffeeshop.catalogservice.domain.Size;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration")
class CatalogServiceApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void whenGetRequestWithIdThenProductReturned() {
        var productToCreate = Product.of(Category.Espresso, Size.Large, 9.90);
        Product expectedProduct= webTestClient
                .post()
                .uri("/products")
                .bodyValue(productToCreate)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Product.class).value(product -> assertThat(product).isNotNull())
                .returnResult().getResponseBody();

        webTestClient
                .get()
                .uri("/products/" + Category.Espresso+ "/" +Size.Large)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Product.class).value(actualProduct-> {
                    assertThat(actualProduct).isNotNull();
                    assertThat(actualProduct.category()).isEqualTo(expectedProduct.category());
                });
    }

//    @Test
//    void whenPostRequestThenProductCreated() {
//        var expectedProduct= Product.of("1231231231", "Title", "Author", 9.90, "Voyagersophia");
//
//        webTestClient
//                .post()
//                .uri("/products")
//                .bodyValue(expectedProduct)
//                .exchange()
//                .expectStatus().isCreated()
//                .expectBody(Product.class).value(actualProduct-> {
//                    assertThat(actualProduct).isNotNull();
//                    assertThat(actualProduct.isbn()).isEqualTo(expectedProduct.isbn());
//                });
//    }
//
//    @Test
//    void whenPutRequestThenProductUpdated() {
//        var productIsbn = "1231231232";
//        var productToCreate = Product.of(productIsbn, "Title", "Author", 9.90, "Voyagersophia");
//        ProductcreatedProduct= webTestClient
//                .post()
//                .uri("/products")
//                .bodyValue(productToCreate)
//                .exchange()
//                .expectStatus().isCreated()
//                .expectBody(Product.class).value(product -> assertThat(product).isNotNull())
//                .returnResult().getResponseBody();
//        var productToUpdate = new Product(createdProduct.id(), createdProduct.isbn(), createdProduct.title(), createdProduct.author(), 7.95,
//                createdProduct.publisher(), createdProduct.createdDate(), createdProduct.lastModifiedDate(), createdProduct.version());
//
//        webTestClient
//                .put()
//                .uri("/products/" + productIsbn)
//                .bodyValue(productToUpdate)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(Product.class).value(actualProduct-> {
//                    assertThat(actualProduct).isNotNull();
//                    assertThat(actualProduct.price()).isEqualTo(productToUpdate.price());
//                });
//    }
//
//    @Test
//    void whenDeleteRequestThenProductDeleted() {
//        var productIsbn = "1231231233";
//        var productToCreate = Product.of(productIsbn, "Title", "Author", 9.90, "Voyagersophia");
//        webTestClient
//                .post()
//                .uri("/products")
//                .bodyValue(productToCreate)
//                .exchange()
//                .expectStatus().isCreated();
//
//        webTestClient
//                .delete()
//                .uri("/products/" + productIsbn)
//                .exchange()
//                .expectStatus().isNoContent();
//
//        webTestClient
//                .get()
//                .uri("/products/" + productIsbn)
//                .exchange()
//                .expectStatus().isNotFound()
//                .expectBody(String.class).value(errorMessage ->
//                        assertThat(errorMessage).isEqualTo("The product with ISBN " + productIsbn + " was not found.")
//                );
//    }

}
