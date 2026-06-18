package com.example.macaron;

import jakarta.validation.constraints.NotBlank;//文字列が空白のみで構成されていないか確認
import jakarta.validation.constraints.Email;//メールアドレスの形式をチェック
import jakarta.validation.constraints.Size;//文字列の長さを制限


//編集するためにfinalなし
public class UserForm {
    // private int id;
    @NotBlank(message = "名前を入力してください")
    private String name;
    @NotBlank(message = "メールアドレスを入力してください")
    @Email(message = "メールアドレスの形式が正しくありません")
    @Size(max = 100, message = "メールアドレスは100文字以内で入力してください")
private String email;

    private String mail;
     
    @NotBlank(message = "パスワードを入力してください")
    private String password;

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
    public void setReviewd(boolean reviewed) {
        this.reviewed = reviewed;
    }
}