package com.example.demo.bean;

public class DataStat {
    public String name;
    public Integer price;

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

    public DataStat(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
