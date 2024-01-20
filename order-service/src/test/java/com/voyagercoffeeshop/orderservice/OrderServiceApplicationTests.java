package com.voyagercoffeeshop.orderservice;

import com.voyagercoffeeshop.orderservice.product.Category;
import com.voyagercoffeeshop.orderservice.product.Product;
import com.voyagercoffeeshop.orderservice.product.ProductClient;
import com.voyagercoffeeshop.orderservice.product.Size;
import com.voyagercoffeeshop.orderservice.order.domain.Order;
import com.voyagercoffeeshop.orderservice.order.domain.OrderStatus;
import com.voyagercoffeeshop.orderservice.order.web.OrderRequest;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class OrderServiceApplicationTests {

	@Container
	static PostgreSQLContainer<?> postgresql = new PostgreSQLContainer<>(DockerImageName.parse("postgres:14.10"));

	@Autowired
	private WebTestClient webTestClient;

	@MockBean
	private ProductClient productClient;

	@DynamicPropertySource
	static void postgresqlProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.r2dbc.url", OrderServiceApplicationTests::r2dbcUrl);
		registry.add("spring.r2dbc.username", postgresql::getUsername);
		registry.add("spring.r2dbc.password", postgresql::getPassword);
		registry.add("spring.flyway.url", postgresql::getJdbcUrl);
	}

	private static String r2dbcUrl() {
		return String.format("r2dbc:postgresql://%s:%s/%s", postgresql.getHost(),
				postgresql.getMappedPort(PostgreSQLContainer.POSTGRESQL_PORT), postgresql.getDatabaseName());
	}

	@Test
	void whenGetOrdersThenReturn() {
		Product product = new Product(Category.Espresso, Size.Large, 9.90);
		given(productClient.getProductByCategoryAndSize(product.category(), product.size())).willReturn(Mono.just(product));
		OrderRequest orderRequest = new OrderRequest(product.category(),product.size(), 1);
		Order expectedOrder = webTestClient.post().uri("/orders")
				.bodyValue(orderRequest)
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBody(Order.class).returnResult().getResponseBody();
		assertThat(expectedOrder).isNotNull();

		webTestClient.get().uri("/orders")
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBodyList(Order.class).value(orders -> {
					assertThat(orders.stream().filter(order -> order.productCategory().equals(product.category())).findAny()).isNotEmpty();
				});
	}

	@Test
	void whenPostRequestAndProductExistsThenOrderAccepted() {
		Product product = new Product(Category.Latte, Size.Large, 12.90);
		given(productClient.getProductByCategoryAndSize(product.category(), product.size())).willReturn(Mono.just(product));
		OrderRequest orderRequest = new OrderRequest(Category.Latte, Size.Large, 3);

		Order createdOrder = webTestClient.post().uri("/orders")
				.bodyValue(orderRequest)
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBody(Order.class).returnResult().getResponseBody();

		assertThat(createdOrder).isNotNull();
		assertThat(createdOrder.productCategory()).isEqualTo(orderRequest.category());
		assertThat(createdOrder.quantity()).isEqualTo(orderRequest.quantity());
		assertThat(createdOrder.productSize()).isEqualTo(product.size());
		assertThat(createdOrder.productPrice()).isEqualTo(product.price());
		assertThat(createdOrder.status()).isEqualTo(OrderStatus.ACCEPTED);
	}

	@Test
	void whenPostRequestAndProductNotExistsThenOrderRejected() {
		String productIsbn = "1234567894";
		given(productClient.getProductByCategoryAndSize(Category.Latte, Size.Large)).willReturn(Mono.empty());
		OrderRequest orderRequest = new OrderRequest(Category.Latte, Size.Large, 3);

		Order createdOrder = webTestClient.post().uri("/orders")
				.bodyValue(orderRequest)
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBody(Order.class).returnResult().getResponseBody();

		assertThat(createdOrder).isNotNull();
		assertThat(createdOrder.productCategory()).isEqualTo(orderRequest.category());
		assertThat(createdOrder.quantity()).isEqualTo(orderRequest.quantity());
		assertThat(createdOrder.status()).isEqualTo(OrderStatus.REJECTED);
	}

}
