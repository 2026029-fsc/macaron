package com.example.macaron;

import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserSubmitRepository {
    private final JdbcClient jdbcClient;

    public UserSubmitRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // mypageに新規ユーザーの情報を追加する
    public void mypage(User form) {
        jdbcClient.sql("INSERT INTO User (mail,name,password,reviewed)VALUES(:mail,:name,:password,:reviewed)")
                .param("mail", form.getMail())
                .param("name", form.getName())
                .param("password", form.getPassword())
                .param("reviewed", form.getReviewed())
                .update();
    }

    // Userのidを選択してそのメールアドレスとユーザーネームとパスワードを表示したい
    public Optional<User> findById(Long id) {
        return jdbcClient.sql("SELECT id,mail,name,password FROM User WHERE id=:id")
                .param("id", id)
                .query(User.class)
                .optional();
    }

    // パスワードをハッシュ化する
    public Optional<String> findPasswordHash(String mail) {// <String>にする！
        return jdbcClient.sql("SELECT password_hash FROM User WHERE mail= :mail")
                .param("mail", mail)
                // .query(User.class)
                .query(String.class)// ここもString!!!
                .optional();
    }

}
