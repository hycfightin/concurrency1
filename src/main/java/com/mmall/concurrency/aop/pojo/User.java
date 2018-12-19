package com.mmall.concurrency.aop.pojo;

public class User {
    private String id;
    private String userName;
    private String note;

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getNote() {
        return note;
    }
}
