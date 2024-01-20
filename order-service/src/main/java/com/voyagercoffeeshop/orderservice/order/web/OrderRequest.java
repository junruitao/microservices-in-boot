package com.voyagercoffeeshop.orderservice.order.web;

import com.voyagercoffeeshop.orderservice.product.Category;
import com.voyagercoffeeshop.orderservice.product.Size;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(

		@NotNull(message = "The product Category must be defined.") Category category,
		@NotNull(message = "The product Size must be defined.") Size size,
		@NotNull(message = "The product quantity must be defined.") @Min(value = 1, message = "You must order at least 1 item.") @Max(value = 5, message = "You cannot order more than 5 items.") Integer quantity

) {
}
