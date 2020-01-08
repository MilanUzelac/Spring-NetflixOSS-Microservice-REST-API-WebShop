package com.example.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/createUsers")
    public String createProducts(){
        userRepository.saveAll(Arrays.asList(new User(1,"Pera","Peric"),new User(2,"Mita","Mitic")));
        return "Users are created!";
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userRepository.findById(id).get();
    }

    @GetMapping("/getUserId/{id}")
    public Long getUserId(@PathVariable("id") Long id){
        return userRepository.findById(id).get().getUserId();
    }

    @GetMapping("/getAllUsers")
    public List<User> getProducts(){
        return userRepository.findAll();
    }

}
