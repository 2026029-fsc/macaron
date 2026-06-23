package com.example.macaron;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;//メールアドレスの形式をチェック
import jakarta.validation.constraints.NotBlank;//入力されているかチェック
import jakarta.validation.constraints.Size;//文字列の長さを制限

//編集するためにfinalなし
public class UserForm {
    //ユーザーネーム
    @NotBlank(message = "ユーザーネームは必須項目です。")
    @Size(max=30,message = "ユーザーネームは30文字以内で入力してください。")//ユーザーネームは30文字まで
    private String name;
       
    //メールアドレス
    @NotBlank(message = "メールアドレスは必須項目です。")
    @Size(max = 100, message = "メールアドレスは100文字以内で入力してください。")//メールアドレス100文字まで
    @Email(message = "メールアドレスの形式が正しくありません。")
    private String mail;
    
    //パスワード
    @NotBlank(message = "パスワードは必須項目です。")
    @Size(min = 8, message = "パスワードは8文字以上で入力してください。")//パスワードは最低8文字
    private String password;

    //確認用パスワード
    @NotBlank(message = "パスワード(確認)は必須項目です。")
    private String password2;

    //パスワードとパスワード確認用を同じにする
    @AssertTrue(message = "パスワードとパスワードの確認用は同一にしてください。")
    public boolean isPasswordValid() {
		if (password == null || password.isEmpty()) {
			return true;
		}
		return password.equals(password2);
	} 
    private boolean reviewed;

    //ゲッター
    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    public boolean getReviewed() {
        return reviewed;
    }

    //セッター
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setReviewd(boolean reviewed) {
        this.reviewed = reviewed;
    }
}
