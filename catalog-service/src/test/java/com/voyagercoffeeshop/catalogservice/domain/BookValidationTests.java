package com.voyagercoffeeshop.catalogservice.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductValidationTests {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

//    @Test
//    void whenAllFieldsCorrectThenValidationSucceeds() {
//        var product = Product.of("1234567890", "Title", "Author", 9.90, "Voyagersophia");
//        Set<ConstraintViolation<Product>> violations = validator.validate(product);
//        assertThat(violations).isEmpty();
//    }
//
//    @Test
//    void whenIsbnNotDefinedThenValidationFails() {
//        var product = Product.of("", "Title", "Author", 9.90, "Voyagersophia");
//        Set<ConstraintViolation<Product>> violations = validator.validate(product);
//        assertThat(violations).hasSize(2);
//        List<String> constraintViolationMessages = violations.stream()
//                .map(ConstraintViolation::getMessage).collect(Collectors.toList());
//        assertThat(constraintViolationMessages)
//                .contains("The product ISBN must be defined.")
//				.contains("The ISBN format must be valid.");
//    }
//
//    @Test
//    void whenIsbnDefinedButIncorrectThenValidationFails() {
//        var product = Product.of("a234567890", "Title", "Author", 9.90, "Voyagersophia");
//        Set<ConstraintViolation<Product>> violations = validator.validate(product);
//        assertThat(violations).hasSize(1);
//        assertThat(violations.iterator().next().getMessage())
//				.isEqualTo("The ISBN format must be valid.");
//    }
//
//    @Test
//    void whenTitleIsNotDefinedThenValidationFails() {
//        var product = Product.of("1234567890", "", "Author", 9.90, "Voyagersophia");
//        Set<ConstraintViolation<Product>> violations = validator.validate(product);
//        assertThat(violations).hasSize(1);
//        assertThat(violations.iterator().next().getMessage())
//                .isEqualTo("The product title must be defined.");
//    }
//
//    @Test
//    void whenAuthorIsNotDefinedThenValidationFails() {
//        var product = Product.of("1234567890", "Title", "", 9.90, "Voyagersophia");
//        Set<ConstraintViolation<Product>> violations = validator.validate(product);
//        assertThat(violations).hasSize(1);
//        assertThat(violations.iterator().next().getMessage())
//                .isEqualTo("The product author must be defined.");
//    }
//
//    @Test
//    void whenPriceIsNotDefinedThenValidationFails() {
//        var product = Product.of("1234567890", "Title", "Author", null, "Voyagersophia");
//        Set<ConstraintViolation<Product>> violations = validator.validate(product);
//        assertThat(violations).hasSize(1);
//        assertThat(violations.iterator().next().getMessage())
//                .isEqualTo("The product price must be defined.");
//    }
//
//    @Test
//    void whenPriceDefinedButZeroThenValidationFails() {
//        var product = Product.of("1234567890", "Title", "Author", 0.0, "Voyagersophia");
//        Set<ConstraintViolation<Product>> violations = validator.validate(product);
//        assertThat(violations).hasSize(1);
//        assertThat(violations.iterator().next().getMessage())
//                .isEqualTo("The product price must be greater than zero.");
//    }
//
//    @Test
//    void whenPriceDefinedButNegativeThenValidationFails() {
//        var product = Product.of("1234567890", "Title", "Author", -9.90, "Voyagersophia");
//        Set<ConstraintViolation<Product>> violations = validator.validate(product);
//        assertThat(violations).hasSize(1);
//        assertThat(violations.iterator().next().getMessage())
//                .isEqualTo("The product price must be greater than zero.");
//    }
//
//    @Test
//    void whenPublisherIsNotDefinedThenValidationSucceeds() {
//        Productproduct = Product.of("1234567890", "Title", "Author", 9.90,null);
//        Set<ConstraintViolation<Product>> violations = validator.validate(product);
//        assertThat(violations).isEmpty();
//    }

}
