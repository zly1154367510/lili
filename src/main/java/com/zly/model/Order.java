package com.zly.model;

import java.util.Date;

public class Order {
    private Long id;

    private String payment;

    private Date createTime;

    private Long uId;

    private String address;

    private String name;

    public Order(Long id, String payment, Date createTime, Long uId, String address, String name) {
        this.id = id;
        this.payment = payment;
        this.createTime = createTime;
        this.uId = uId;
        this.address = address;
        this.name = name;
    }

    public Order() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}