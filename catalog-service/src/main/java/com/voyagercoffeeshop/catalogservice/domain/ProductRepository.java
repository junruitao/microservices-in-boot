package com.voyagercoffeeshop.catalogservice.domain;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends CrudRepository<Product,Long> {
	Optional<Product> findByCategoryAndSize(Category category, Size size);
	boolean existsByCategoryAndSize(Category category, Size size);

	@Modifying
	@Transactional
	@Query("delete from Product where category = :category and size = :size")
	void deleteByCategoryAndSize(Category category, Size size);

}
