package com.voyagercoffeeshop.catalogservice.domain;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	public Iterable<Product> viewProductList() {
        return productRepository.findAll();
    }

    public Product viewProductDetails(Category category, Size size) {
        return productRepository.findByCategoryAndSize(category,size)
                .orElseThrow(() -> new ProductNotFoundException(category, size));
    }

    public Product addProductToCatalog(Product product) {
        if (productRepository.existsByCategoryAndSize(product.category(), product.size())) {
            throw new ProductAlreadyExistsException(product.category(), product.size());
        }
        return productRepository.save(product);
    }

    public void removeProductFromCatalog(Category category, Size size) {
        productRepository.deleteByCategoryAndSize(category, size);
    }

	public Product editProductDetails(Category category, Size size, Product product) {
		return productRepository.findByCategoryAndSize(product.category(), product.size())
				.map(existingProduct-> {
					var productToUpdate = new Product(
							existingProduct.id(),
							product.category(),
							product.size(),
							product.price(),
							existingProduct.createdDate(),
							existingProduct.lastModifiedDate(),
							existingProduct.version());
					return productRepository.save(productToUpdate);
				})
				.orElseGet(() -> addProductToCatalog(product));
	}

}
