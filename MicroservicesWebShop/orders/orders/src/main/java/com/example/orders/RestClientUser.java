package com.example.orders;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("user-service")
public interface RestClientUser {
        @RequestMapping("/createUsers")
        String createUsers();

        @RequestMapping("/getAllUsers")
        List<User> getAllUsers();

        @RequestMapping("/getUserById/{id}")
        User getUserById(@PathVariable("id") Long id);

        @RequestMapping("/getUserId/{id}")
        Long getUserId(@PathVariable("id") Long id);

}
