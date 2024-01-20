package com.voyagercoffeeshop.orderservice.order.domain;

import com.voyagercoffeeshop.orderservice.product.Category;
import com.voyagercoffeeshop.orderservice.product.Product;
import com.voyagercoffeeshop.orderservice.product.ProductClient;
import com.voyagercoffeeshop.orderservice.product.Size;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private final ProductClient productClient;
	private final OrderRepository orderRepository;

	public OrderService(ProductClient productClient, OrderRepository orderRepository) {
		this.productClient = productClient;
		this.orderRepository = orderRepository;
	}

	public Flux<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Mono<Order> submitOrder(Category category, Size size, int quantity) {
		return productClient.getProductByCategoryAndSize(category, size)
				.map(product -> buildAcceptedOrder(product, quantity))
				.defaultIfEmpty(buildRejectedOrder(category,size, quantity))
				.flatMap(orderRepository::save);
	}

	public static Order buildAcceptedOrder(Product product, int quantity) {
		return Order.of(product.category(), product.size(),
				product.price(), quantity, OrderStatus.ACCEPTED);
	}

	public static Order buildRejectedOrder(Category category, Size size, int quantity) {
		return Order.of(category, size, null, quantity, OrderStatus.REJECTED);
	}

}
