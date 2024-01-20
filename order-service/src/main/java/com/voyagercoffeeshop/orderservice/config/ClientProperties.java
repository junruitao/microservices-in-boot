package com.voyagercoffeeshop.orderservice.config;

import java.net.URI;

import jakarta.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "voyager")
public record ClientProperties (

	@NotNull
	URI catalogServiceUri

){}
