package com.example.demo.bean;

public class Good {
    private String goodID;
    private String name;
    private Integer price;
    private Integer number;
    private String picture;
    private String introduction;

    public Good(String goodID, String name, Integer price, Integer number, String picture, String introduction) {
        this.goodID = goodID;
        this.name = name;
        this.price = price;
        this.number = number;
        this.picture = picture;
        this.introduction = introduction;
    }

    public Good(){
    }

    public String getGoodID() {
        return goodID;
    }

    public void setGoodID(String goodID) {
        this.goodID = goodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
