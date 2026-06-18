package com.example.macaron;

//メール、名前、パスワード、レビューフラグが編集可能
public class User {
    private final int id;
    private String mail;
    private String name;
    private String password;
    private boolean reviewed;
    
    public User(int id, String mail, String name, String password, boolean reviewed) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.reviewed = reviewed;
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
    public boolean getReviewed() {
        return reviewed;
    }

    public void setMailid(String mail) {
        this.mail = mail;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setReviewd(boolean reviewed) {
        this.reviewed = reviewed;
    }
}
