package com.voyagercoffeeshop.catalogservice.domain;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record Product(

		@Id Long id,

		@NotNull(message = "The category must be defined.") Category category,

		@NotNull(message = "The product size must be defined.") Size size,

		@NotNull(message = "The product price must be defined.") @Positive(message = "The product price must be greater than zero.") Double price,

		@CreatedDate Instant createdDate,

		@LastModifiedDate Instant lastModifiedDate,

		@Version int version

) {

	public static Product of(Category category, Size size, Double price) {
		return new Product(null, category, size, price, null, null, 0);
	}

}
