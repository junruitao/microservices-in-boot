package com.voyagercoffeeshop.catalogservice;

import com.voyagercoffeeshop.catalogservice.config.VoyagerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private final VoyagerProperties voyagerProperties;

	public HomeController(VoyagerProperties voyagerProperties) {
		this.voyagerProperties = voyagerProperties;
	}

	@GetMapping("/")
	public String getGreeting() {
		return voyagerProperties.getGreeting();
	}

}
