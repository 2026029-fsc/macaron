package com.example.macaron;

import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserSubmitRepository {
    private final JdbcClient jdbcClient;

    public UserSubmitRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }
    
    // ユーザー登録
    public void insertUser(String name, String mail, String passwordhash) {

        jdbcClient.sql("INSERT INTO User (mail,name,password,reviewed) VALUES (:mail,:name,:password,:reviewed)")
        .param("mail", mail)
        .param("name", name)
        .param("password", passwordhash)
        .param("reviewed", false)
        .update();
    }
    // Userのidを選択してそのメールアドレスとユーザーネームとパスワードを表示したい
    public Optional<User> findById(Long id) { // DBのINTに合わせてIntegerに変更
        return jdbcClient.sql("SELECT id, mail, name, password, reviewed FROM User WHERE id = :id")
                .param("id", id)
                .query(User.class)
                .optional();
    }


    // //mypageに新規ユーザーの情報を追加する
    // public void mypage(User form){
    // jdbcClient.sql("INSERT INTO User (mail,name,password,reviewed)VALUES(:mail,:name,:password,:reviewed)")
    //     .param("mail",form.getMail())
    //     .param("name",form.getName())
    //     .param("password",form.getPassword())
    //     .param("reviewed",form.getReviewed())
    //     .update();
    // }

    // //Userのidを選択してそのメールアドレスとユーザーネームとパスワードを表示したい
    // public Optional <User>findById(Long id){
    //     return jdbcClient.sql("SELECT id,mail,name,password FROM User WHERE id=:id")
    //     .param("id",id)    
    //     .query(User.class)
    //     .optional();
    // }


    // メールアドレスの重複チェック
    public boolean existsByMail(String mail) {
        Integer count = jdbcClient.sql("SELECT COUNT(*) FROM User WHERE mail = :mail")
            .param("mail", mail)
            .query(Integer.class)
            .single();
        return count != null && count > 0;
    }

    // メールアドレスからユーザー情報を取得
    public Optional<User> findByMail(String mail){
        return jdbcClient.sql("SELECT id, mail, name, password, reviewed FROM User WHERE mail = :mail")
            .param("mail", mail)    
            .query(User.class)
            .optional();
    }
}

