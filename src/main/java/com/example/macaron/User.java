package com.example.macaron;

//メール、名前、パスワード、レビューフラグが編集可能
public class User {
    private final Long id;
    private String mailid;
    private String name;
    private String password;
    private boolean reviewed;
    
    public User(Long id, String mailid, String name, String password, boolean reviewed) {
        this.id = id;
        this.mailid = mailid;
        this.name = name;
        this.password = password;
        this.reviewed = reviewed;
    }
    public Long getId() {
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
    public boolean getReviewed() {
        return reviewed;
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
    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }
}
