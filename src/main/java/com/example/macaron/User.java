package com.example.macaron;

//メール、名前、パスワード、レビューフラグが編集可能
public class User {
    private final int id;
    private final String mail;
    private final String name;
    private final String password;
    private final boolean reviewd;
    
    public User(int id, String mail, String name, String password, boolean reviewd) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.reviewd = reviewd;
    }
    public int getId() {
        return id;
    }
    public String getMail() {
        return mail;
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

}
