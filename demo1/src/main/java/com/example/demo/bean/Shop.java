package com.example.demo.bean;


public class Shop {
    private String account;  //用户的唯一标识账户
    private String goodID; //商品的唯一标识ID

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getGoodID() {
        return goodID;
    }

    public void setGoodID(String goodID) {
        this.goodID = goodID;
    }

    public Shop(String account, String goodID) {
        this.account = account;
        this.goodID = goodID;
    }

    public Shop(){
    }
}
