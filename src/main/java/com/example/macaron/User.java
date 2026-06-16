package com.example.macaron;

//メール、名前、パスワード、レビューフラグが編集可能
public class User {
    private final int id;
    private String mailid;
    private String name;
    private String password;
    private boolean reviewd;
    
    public User(int id, String mailid, String name, String password, boolean reviewd) {
        this.id = id;
        this.mailid = mailid;
        this.name = name;
        this.password = password;
        this.reviewd = reviewd;
    }
    public int getId() {
        return id;
    }
    public String getMailid() {
        return mailid;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public boolean getReviewd() {
        return reviewd;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setReviewd(boolean reviewd) {
        this.reviewd = reviewd;
    }
}
