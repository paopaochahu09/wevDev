package com.example.demo.bean;

public class User {
    private String name;
    private String account; //可以用来标识唯一用户
    private String password;
    private String picture;
    private String address;

    public String getName() {
        return name;
    }

    public User() {
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getPicture() {
        return picture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String name, String account, String password, String picture, String address) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.picture = picture;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
