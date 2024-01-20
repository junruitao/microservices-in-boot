package com.voyagercoffeeshop.catalogservice.domain;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.voyagercoffeeshop.catalogservice.domain.ProductAlreadyExistsException;
import com.voyagercoffeeshop.catalogservice.domain.ProductNotFoundException;
import com.voyagercoffeeshop.catalogservice.domain.ProductRepository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productservice;
//
//    @Test
//    void whenProductToCreateAlreadyExistsThenThrows() {
//        var productIsbn = "1234561232";
//        var productToCreate = Product.of(productIsbn, "Title", "Author", 9.90, "Voyagersophia");
//        when(productRepository.existsByIsbn(productIsbn)).thenReturn(true);
//        assertThatThrownBy(() -> productservice.addProductToCatalog(productToCreate))
//                .isInstanceOf(ProductAlreadyExistsException.class)
//                .hasMessage("A product with ISBN " + productIsbn + " already exists.");
//    }
//
//	@Test
//	void whenProductToReadDoesNotExistThenThrows() {
//		var productIsbn = "1234561232";
//		when(productRepository.findByIsbn(productIsbn)).thenReturn(Optional.empty());
//		assertThatThrownBy(() -> productservice.viewProductDetails(productIsbn))
//				.isInstanceOf(ProductNotFoundException.class)
//				.hasMessage("The product with ISBN " + productIsbn + " was not found.");
//	}

}
