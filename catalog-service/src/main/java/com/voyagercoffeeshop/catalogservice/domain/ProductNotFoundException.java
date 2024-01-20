package com.voyagercoffeeshop.catalogservice.domain;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(Category category, Size size) {
		super("The product with " + category + ", " + size + " was not found.");
	}

}
