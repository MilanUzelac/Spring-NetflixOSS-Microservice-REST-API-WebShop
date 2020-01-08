package com.example.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private OrderRepository orderRepository;
    private RestClient restClient;
    private RestClientUser restClientUser;


    @Autowired
    public OrderController(OrderRepository orderRepository, RestClient restClient,RestClientUser restClientUser) {
        this.orderRepository = orderRepository;
        this.restClient = restClient;
        this.restClientUser=restClientUser;
    }

    @GetMapping("/getUsersFromOrder")
    public List<User> getUsers(){
        return restClientUser.getAllUsers();
    }

    @GetMapping("/createUsersFromOrder")
    public String createUsers(){
        return restClientUser.createUsers();
    }

    @GetMapping("/getUserbyId/{id}")
    public User getUserbyRequestedId(@PathVariable("id") Long id){
        return restClientUser.getUserById(id);
    }

    @GetMapping("/getOrderFrom/{id}/orders")
    public Optional<Order> getOrder(@PathVariable("id") Long userId){
        return orderRepository.findById(restClientUser.getUserById(userId).getUserId());
    }

    @PostMapping("/createOrderFrom/{id}/{productId}")
    public String setOrder(@PathVariable("id") Long id,@PathVariable("productId") Long productId){
        Order order = new Order(5,getUserbyRequestedId(id).getUserId(),getProductsByid(productId),199999);
        orderRepository.save(order);
        return "Order is successfully added!";
    }

    @RequestMapping(value = "/createOrderFrom",method = RequestMethod.POST)
    public String postRequest(@RequestParam("id") Long id,@RequestParam("productId") Long productId){
        Order order = new Order(5,getUserbyRequestedId(id).getUserId(),getProductsByid(productId),199999);
        orderRepository.save(order);
        return "Order is saved!";
    }

    @RequestMapping(value = "/getOrderFrom",method = RequestMethod.GET)
    public Optional<Order> getRequest(@RequestParam("id") Long userId){
        return orderRepository.findOrderByUserId(userId);
    }

    @GetMapping("/orderProductById/{id}")
    public Product getProductsByid(@PathVariable("id") Long id){
        return restClient.getProductsById(id);
    }


    Product products2 = new Product(1,"Bazen",25000);

    @GetMapping("/createOrder")
    public String createOrder(){
        orderRepository.saveAll(Arrays.asList(new Order(2,2,products2,120)));
        return "Hardcoded order is created!";
    }

    @GetMapping("/responseOrder")
    public List<Order> responseOrder(){
        return orderRepository.findAll();
    }
}