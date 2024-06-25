package com.example.java_version;
/*
用户信息实体类
 */
public class USinfo {
    private String name;
    private String password;


    public USinfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USinfo(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
