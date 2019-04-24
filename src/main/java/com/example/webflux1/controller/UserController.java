package com.example.webflux1.controller;


import com.example.webflux1.domian.User;
import com.example.webflux1.handler.UserHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
    @Autowired
    private UserHandler userHandler;

    @GetMapping("findUserById")
    public Mono<User> findUserById(@RequestParam long id){
        return userHandler.findUserById(id);
    }

    @GetMapping("findAllUser")
    public Flux<User> findAllUser(){
       // System.out.println("findAllUser");
        Flux<User> allUser = userHandler.findAllUser();
        System.out.println(allUser);
        return userHandler.findAllUser();
    }

    @PostMapping("insertUser")
    public Mono<Long> saveUser(@RequestBody User user){
        Mono<Long> save = userHandler.save(user);
        //System.out.println(user);
        return save;
    }

    @PutMapping("modifyUser")
    public Mono<Long> modifyUser(@RequestBody User user){
        Mono<Long> longMono = userHandler.modifyCity(user);
        return longMono;
    }

    @DeleteMapping("deleteUserById")
    public Mono<Long> deleteUserById(@RequestParam long id){
        Mono<Long> longMono = userHandler.deleteUserById(id);
        return longMono;
    }
}
