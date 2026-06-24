package com.example.macaron;

//メール、名前、パスワード、レビューフラグが編集可能
public class User {
    private final Integer id;
    private final String mail;
    private final String name;
    private final String password;
    // private final String password2;
    private final boolean reviewed;

    public User(Integer id, String mail, String name, String password, /*String password2,*/ boolean reviewed) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.reviewed = reviewed;
    }

    public Integer getId() {
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
