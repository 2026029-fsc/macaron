package com.example.macaron;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserSubmitRepository {
    private final JdbcClient jdbcClient;

    public UserSubmitRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    //mypageに新規ユーザーの情報を追加する
    public void mypage(UserForm form){
    jdbcClient.sql("INSERT INTO User (mail,name,password,reviewd)VALUES(:mail,:name,:password,:reviewd)")
        .param("mail",form.getMail())
        .param("name",form.getName())
        .param("password",form.getPassword())
        .param("reviewed",form.getReviewd())
        .update();
    }
}
