package com.example.webflux1.handler;

import com.example.webflux1.domian.User;
import com.example.webflux1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 处理器类
 * Mono：实现发布者，并返回 0 或 1 个元素，即单对象。
 * Flux：实现发布者，并返回 N 个元素，即 List 列表对象。
 */
@Component
public class UserHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<Long> save(User user){
        Mono<Long> saveEnd = Mono.create(userMonoSink -> userMonoSink.success(userRepository.save(user)));
        return saveEnd;
    }

    public Mono<User> findUserById(long id){
        Mono<User> user = Mono.justOrEmpty(userRepository.findUserById(id));
        return user;
    }

    public Flux<User> findAllUser(){
        Flux<User> userFlux = Flux.fromIterable(userRepository.findAll());
        return userFlux;
    }

    public Mono<Long> deleteUserById(long id){
        Mono<Long> objectMono = Mono.create(userMonoLink -> userMonoLink.success(userRepository.deleteUser(id)));
        return objectMono;
    }

    public Mono<Long> modifyCity(User user){
        Mono<Long> objectMono = Mono.create(userMonoLink -> userMonoLink.success(userRepository.updateUser(user)));
        return objectMono;
    }
}
