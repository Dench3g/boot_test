package com.example.demo;

public class MyException extends Exception {
    private final String key;

    public MyException(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
