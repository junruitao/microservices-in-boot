package com.voyagercoffeeshop.catalogservice.demo;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.voyagercoffeeshop.catalogservice.domain.Category;
import com.voyagercoffeeshop.catalogservice.domain.Product;
import com.voyagercoffeeshop.catalogservice.domain.ProductRepository;
import com.voyagercoffeeshop.catalogservice.domain.Size;

@Component
@Profile("testdata")
public class ProductDataLoader {

	private final ProductRepository productRepository;

	public ProductDataLoader(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void loadProductTestData() {
		productRepository.deleteAll();
		var product1 = Product.of(Category.Espresso, Size.Large, 9.90);
		var product2 = Product.of(Category.Latte, Size.Medium, 7.90);
		productRepository.saveAll(List.of(product1, product2));
	}

}
