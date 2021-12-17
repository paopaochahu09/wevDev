package com.example.demo.bean;

public class Record {
    private Long naviTime;
    private String account;
    private String goodID;
    private String name;

    public Record() {
    }

    public Record(Long naviTime, String account, String goodID, String name) {
        this.naviTime = naviTime;
        this.account = account;
        this.goodID = goodID;
        this.name = name;
    }

    public Long getNaviTime() {
        return naviTime;
    }

    public void setNaviTime(Long naviTime) {
        this.naviTime = naviTime;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
