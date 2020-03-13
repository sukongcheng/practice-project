package com.shiyanlou.spring.entity;

public class CustomerService {

    private String name;
    private String url;

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void printName(){
        System.out.println("Customer's name:" + name);
    }

    public void printUrl(){
        System.out.println("Customer's url:" + url);
    }

    public void throwException(){
        throw new IllegalArgumentException();
    }
}
