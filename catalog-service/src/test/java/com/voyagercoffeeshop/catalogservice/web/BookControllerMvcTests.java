package com.voyagercoffeeshop.catalogservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductController.class)
class ProductControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private productservice productservice;
//
//    @Test
//    void whenGetProductNotExistingThenShouldReturn404() throws Exception {
//        String isbn = "73737313940";
//        given(productservice.viewProductDetails(isbn)).willThrow(ProductNotFoundException.class);
//        mockMvc
//                .perform(get("/products/" + isbn))
//                .andExpect(status().isNotFound());
//    }

}
