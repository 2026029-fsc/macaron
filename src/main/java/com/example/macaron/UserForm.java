package com.example.macaron;


//編集するためにfinalなし
public class UserForm {
    // private int id;
    private String mail;
    private String name;
    private String password;
    private boolean reviewd;
   
    // public UserForm(int id, String mail, String name, String password, boolean reviewd) {
    //     this.id = id;
    //     this.mail = mail;
    //     this.name = name;
    //     this.password = password;
    //     this.reviewd = reviewd;
    // }


    // public int getId() {
    //     return id;
    // }
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


    public void setMail(String mail) {
        this.mail = mail;
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
