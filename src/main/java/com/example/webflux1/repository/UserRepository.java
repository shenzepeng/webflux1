package com.example.webflux1.repository;

import com.example.webflux1.domian.User;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository{
    private ConcurrentHashMap<Long,User> concurrentHashMap=new ConcurrentHashMap<>();
    private static final AtomicLong a=new AtomicLong(0);

    public Long save(User user){
        long id = a.getAndIncrement();
        user.setId(id);
        concurrentHashMap.put(id,user);
        return id;
    }

    public User findUserById(long id){
        return concurrentHashMap.get(id);
    }

    public Long updateUser(User user){
        long id = user.getId();
        User user1 = concurrentHashMap.get(id);
        return id;
    }

    public Long deleteUser(long id){
        concurrentHashMap.remove(id);
        return id;
    }

    public  ArrayList<User> findAll(){
        ArrayList<User> list=new ArrayList<>();
        concurrentHashMap.forEach((key,value)->list.add(value));
        return list;
    }
}
