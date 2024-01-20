package com.voyagercoffeeshop.catalogservice.domain;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.voyagercoffeeshop.catalogservice.config.DataConfig;
import com.voyagercoffeeshop.catalogservice.domain.ProductRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@Import(DataConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
class ProductRepositoryJdbcTests {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private JdbcAggregateTemplate jdbcAggregateTemplate;
//
//    @Test
//    void findAllproducts() {
//        var product1 = Product.of("1234561235", "Title", "Author", 12.90, "Voyagersophia");
//        var product2 = Product.of("1234561236", "Another Title", "Author", 12.90, "Voyagersophia");
//        jdbcAggregateTemplate.insert(product1);
//        jdbcAggregateTemplate.insert(product2);
//
//        Iterable<Product> actualproducts = productRepository.findAll();
//
//        assertThat(StreamSupport.stream(actualproducts.spliterator(), true)
//                .filter(product -> product.isbn().equals(product1.isbn()) || product.isbn().equals(product2.isbn()))
//                .collect(Collectors.toList())).hasSize(2);
//    }
//
//    @Test
//    void findProductByIsbnWhenExisting() {
//        var productIsbn = "1234561237";
//        var product = Product.of(productIsbn, "Title", "Author", 12.90, "Voyagersophia");
//        jdbcAggregateTemplate.insert(product);
//
//        Optional<Product> actualProduct= productRepository.findByIsbn(productIsbn);
//
//        assertThat(actualProduct).isPresent();
//        assertThat(actualProduct.get().isbn()).isEqualTo(product.isbn());
//    }
//
//    @Test
//    void findProductByIsbnWhenNotExisting() {
//        Optional<Product> actualProduct= productRepository.findByIsbn("1234561238");
//        assertThat(actualProduct).isEmpty();
//    }
//
//    @Test
//    void existsByIsbnWhenExisting() {
//        var productIsbn = "1234561239";
//        var productToCreate = Product.of(productIsbn, "Title", "Author", 12.90, "Voyagersophia");
//        jdbcAggregateTemplate.insert(productToCreate);
//
//        boolean existing = productRepository.existsByIsbn(productIsbn);
//
//        assertThat(existing).isTrue();
//    }
//
//    @Test
//    void existsByIsbnWhenNotExisting() {
//        boolean existing = productRepository.existsByIsbn("1234561240");
//        assertThat(existing).isFalse();
//    }
//
//    @Test
//    void deleteByIsbn() {
//        var productIsbn = "1234561241";
//        var productToCreate = Product.of(productIsbn, "Title", "Author", 12.90, "Voyagersophia");
//        var persistedProduct= jdbcAggregateTemplate.insert(productToCreate);
//
//        productRepository.deleteByIsbn(productIsbn);
//
//        assertThat(jdbcAggregateTemplate.findById(persistedProduct.id(), Product.class)).isNull();
//    }

}
