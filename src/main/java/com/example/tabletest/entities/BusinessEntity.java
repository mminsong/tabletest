package com.example.tabletest.entities;

public class BusinessEntity {
    private int index;
    private String userName;
    private String companyName;
    private String name;
    private String level;
    private String num;
    private String email;
    private String address;

    public BusinessEntity() {
    }

    public BusinessEntity(int index, String userName, String companyName, String name, String level, String num, String email, String address) {
        this.index = index;
        this.userName = userName;
        this.companyName = companyName;
        this.name = name;
        this.level = level;
        this.num = num;
        this.email = email;
        this.address = address;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}