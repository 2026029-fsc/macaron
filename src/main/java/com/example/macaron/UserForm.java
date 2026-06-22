package com.example.macaron;

import jakarta.validation.constraints.Email;//メールアドレスの形式をチェック
import jakarta.validation.constraints.Size;//文字列の長さを制限

//編集するためにfinalなし
public class UserForm {
    private String name;
    @Email(message = "メールアドレスの形式が正しくありません")
    @Size(max = 100, message = "メールアドレスは100文字以内で入力してください")
    private String mail;
    private String password;
    // private String password2;//確認用のパスワード　追加
    private boolean reviewed;


    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    // public String getPassword2() {
    //     return password2;
    // }//追加
    public boolean getReviewed() {
        return reviewed;
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

    // public void setPassword2(String password2) {
    //     this.password2 = password2;
    // }
    public void setReviewd(boolean reviewed) {
        this.reviewed = reviewed;
    }
}