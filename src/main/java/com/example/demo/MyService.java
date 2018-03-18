package com.example.demo;

import org.springframework.cache.annotation.Cacheable;

import java.util.UUID;

@org.springframework.stereotype.Service
public class MyService {

    @Cacheable(value = "default", key = "#key")
    public String getUUID(String key) throws MyException {
        if ("err".equals(key))
            throw new MyException(key);
        return UUID.randomUUID().toString();
    }
}
