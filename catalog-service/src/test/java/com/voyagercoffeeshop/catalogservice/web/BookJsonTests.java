package com.voyagercoffeeshop.catalogservice.web;

import java.time.Instant;

import com.voyagercoffeeshop.catalogservice.domain.Product;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class ProductJsonTests {

    @Autowired
    private JacksonTester<Product> json;
//
//    @Test
//    void testSerialize() throws Exception {
//        var now = Instant.now();
//        var product = new Product(394L, "1234567890", "Title", "Author", 9.90, "Voyagersophia", now, now, 21);
//        var jsonContent = json.write(product);
//        assertThat(jsonContent).extractingJsonPathNumberValue("@.id")
//                .isEqualTo(product.id().intValue());
//        assertThat(jsonContent).extractingJsonPathStringValue("@.isbn")
//                .isEqualTo(product.isbn());
//        assertThat(jsonContent).extractingJsonPathStringValue("@.title")
//                .isEqualTo(product.title());
//        assertThat(jsonContent).extractingJsonPathStringValue("@.author")
//                .isEqualTo(product.author());
//        assertThat(jsonContent).extractingJsonPathNumberValue("@.price")
//                .isEqualTo(product.price());
//        assertThat(jsonContent).extractingJsonPathStringValue("@.publisher")
//                .isEqualTo(product.publisher());
//        assertThat(jsonContent).extractingJsonPathStringValue("@.createdDate")
//                .isEqualTo(product.createdDate().toString());
//        assertThat(jsonContent).extractingJsonPathStringValue("@.lastModifiedDate")
//                .isEqualTo(product.lastModifiedDate().toString());
//        assertThat(jsonContent).extractingJsonPathNumberValue("@.version")
//                .isEqualTo(product.version());
//    }
//
//    @Test
//    void testDeserialize() throws Exception {
//        var instant = Instant.parse("2021-09-07T22:50:37.135029Z");
//        var content = """
//                {
//                    "id": 394,
//                    "isbn": "1234567890",
//                    "title": "Title",
//                    "author": "Author",
//                    "price": 9.90,
//                    "publisher": "Voyagersophia",
//                    "createdDate": "2021-09-07T22:50:37.135029Z",
//                    "lastModifiedDate": "2021-09-07T22:50:37.135029Z",
//                    "version": 21
//                }
//                """;
//        assertThat(json.parse(content))
//                .usingRecursiveComparison()
//                .isEqualTo(new Product(394L, "1234567890", "Title", "Author", 9.90, "Voyagersophia", instant, instant, 21));
//    }

}
