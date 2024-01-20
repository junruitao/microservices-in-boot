package com.voyagercoffeeshop.orderservice.order.domain;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import com.voyagercoffeeshop.orderservice.product.Category;
import com.voyagercoffeeshop.orderservice.product.Size;

@Table("orders")
public record Order (

	@Id
	Long id,

	Category productCategory,
	Size productSize,
	Double productPrice,
	Integer quantity,
	OrderStatus status,

	@CreatedDate
	Instant createdDate,

	@LastModifiedDate
	Instant lastModifiedDate,

	@Version
	int version
){

	public static Order of(Category category, Size size, Double productPrice, Integer quantity, OrderStatus status) {
		return new Order(null, category, size, productPrice, quantity, status, null, null, 0);
	}

}
