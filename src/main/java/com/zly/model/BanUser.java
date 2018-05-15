package com.zly.model;

import java.util.Date;

public class BanUser {
    private Integer id;

    private Integer userId;

    private String banReason;

    private Date banDate;

    public BanUser(Integer id, Integer userId, String banReason, Date banDate) {
        this.id = id;
        this.userId = userId;
        this.banReason = banReason;
        this.banDate = banDate;
    }

    public BanUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBanReason() {
        return banReason;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason == null ? null : banReason.trim();
    }

    public Date getBanDate() {
        return banDate;
    }

    public void setBanDate(Date banDate) {
        this.banDate = banDate;
    }
}