package com.example.macaron;

//メール、名前、パスワード、レビューフラグが編集可能
public class User {
    private final Integer id;
    private String mailid;
    private String name;
    private String password;
    private boolean reviewed;
    
    public User(Integer id, String mailid, String name, String password, boolean reviewed) {
        this.id = id;
        this.mailid = mailid;
        this.name = name;
        this.password = password;
        this.reviewed = reviewed;

    }
    public Integer getId() {
        return id;
    }

    public String getMail() {
        return mailid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    // public String getPassword2() {
    //     return password2;
    // }

    public boolean getReviewed() {
        return reviewed;
    }

}