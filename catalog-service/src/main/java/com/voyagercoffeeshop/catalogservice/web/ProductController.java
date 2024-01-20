package com.voyagercoffeeshop.catalogservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.voyagercoffeeshop.catalogservice.domain.Category;
import com.voyagercoffeeshop.catalogservice.domain.Product;
import com.voyagercoffeeshop.catalogservice.domain.ProductService;
import com.voyagercoffeeshop.catalogservice.domain.Size;

import jakarta.validation.Valid;

@RestController
@RequestMapping("products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public Iterable<Product> get() {
		return productService.viewProductList();
	}

	@GetMapping("/{category}/{size}")
	public Product getByCategoryAndSize(@PathVariable("category") Category category, @PathVariable("size") Size size) {
		return productService.viewProductDetails(category, size);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product post(@Valid @RequestBody Product product) {
		return productService.addProductToCatalog(product);
	}

	@DeleteMapping("{category}/{size}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Category category, @PathVariable Size size) {
		productService.removeProductFromCatalog(category, size);
	}

	@PutMapping("{category}/{size}")
	public Product put(@PathVariable Category category, @PathVariable Size size, @Valid @RequestBody Product product) {
		return productService.editProductDetails(category, size, product);
	}

}
