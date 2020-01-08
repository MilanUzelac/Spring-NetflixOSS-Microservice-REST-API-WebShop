package com.example.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/createProd")
    public String createProductss(){
        productRepository.saveAll(Arrays.asList(new Product(1,"Disalica",250),new Product(2,"Bazen",35000),new Product(3,"Jelka",1250)));
        return "Products are created!";
    }



    @GetMapping("/getAllProducts")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/getProductById/{productId}")
    public Product getProductById(@PathVariable("productId") Long productId){
        return productRepository.findById(productId).get();
    }




}
