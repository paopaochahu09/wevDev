package com.example.demo.bean;

public class Order {
    private String orderID;
    private String account; //下单用户
    private String name; //商品名字
    private Integer price; //订单价格
    private String picture; //商品图片
    private Long orderTime; //下单时间，毫秒数
    private Integer isDeal;  //是否确定收货，即该订单是否结束了

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getPicture() {
        return picture;
    }

    public Integer getIsDeal() {
        return isDeal;
    }

    public void setIsDeal(Integer isDeal) {
        this.isDeal = isDeal;
    }

    public Order(String orderID, String account, String name, Integer price, String picture, Long orderTime, Integer isDeal) {
        this.orderID = orderID;
        this.account = account;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.orderTime = orderTime;
        this.isDeal = isDeal;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public Order(){
    }
}
