package com.example.macaron;

import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserSubmitRepository extends SuperRepository {
    private final JdbcClient jdbcClient;

    public UserSubmitRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void insertUser(String name, String mail, String passwordhash) {

        jdbcClient.sql("INSERT INTO User (mail,name,password,reviewed) VALUES (:mail,:name,:password,:reviewed)")
        .param("mail", mail)
        .param("name", name)
        .param("password", passwordhash)
        .param("reviewed", false)
        .update();
        
    }

    // Userのidを選択してそのメールアドレスとユーザーネームとパスワードを表示したい
    public Optional<User> findById(Long id) {
        return jdbcClient.sql("SELECT id,mail,name,password FROM User WHERE id=:id")
                .param("id", id)
                .query(User.class)
                .optional();
    }

    // パスワードを取り出す
    // public Optional<String> findPasswordHash(String mail) {// <String>にする！
    // return jdbcClient.sql("SELECT password FROM User WHERE mail= :mail")
    // .param("mail", mail)
    // // .query(User.class)
    // .query(String.class)// ここもString!!!
    // .optional();
    // }

}
