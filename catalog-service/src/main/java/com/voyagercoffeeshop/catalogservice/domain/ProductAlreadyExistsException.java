package com.voyagercoffeeshop.catalogservice.domain;

public class ProductAlreadyExistsException extends RuntimeException {

	public ProductAlreadyExistsException(Category category, Size size) {
		super("A product with ISBN " + category + ", " + size + " already exists.");
	}

}
