package com.example.orders;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@FeignClient("products-service")
public interface RestClient {

    @RequestMapping("/getAllProducts")
    Product getProducts();

    @RequestMapping("/getProductById/{productId}")
    Product getProductsById(@PathVariable("productId") Long productId);

}
