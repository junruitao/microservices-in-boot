package com.voyagercoffeeshop.orderservice.product;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Component
public class ProductClient {

	private static final String products_ROOT_API = "/products/";
	private final WebClient webClient;

	public ProductClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public Mono<Product> getProductByCategoryAndSize(Category category, Size size) {
		return webClient
				.get()
				.uri(products_ROOT_API + category + "/" + size)
				.retrieve()
				.bodyToMono(Product.class)
				.timeout(Duration.ofSeconds(3), Mono.empty())
				.onErrorResume(WebClientResponseException.NotFound.class, exception -> Mono.empty())
				.retryWhen(Retry.backoff(3, Duration.ofMillis(100)))
				.onErrorResume(Exception.class, exception -> Mono.empty());
	}

}
