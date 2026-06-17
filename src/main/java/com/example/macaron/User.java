package com.example.macaron;

//メール、名前、パスワード、レビューフラグが編集可能
public class User {
    private final Long id;
    private final String mail;
    private final String name;
    private final String password;
    private final boolean reviewed;
    
    public User(Long id, String mail, String name, String password, boolean reviewed) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.reviewed = reviewed;
    }
    public Long getId() {
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

}
