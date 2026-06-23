package com.example.macaron;

import java.util.Optional;
import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserSubmitRepository extends SuperRepository {
    private final JdbcClient jdbcClient;

    public UserSubmitRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    //新規会員登録 ok
    public void insertUser(String name, String mail, String passwordhash) {
        jdbcClient.sql("INSERT INTO User (mail,name,password,reviewed) VALUES (:mail,:name,:password,:reviewed)")
        .param("mail", mail)
        .param("name", name)
        .param("password", passwordhash)
        .param("reviewed", false)
        .update();
    }
    // Userのidを選択してそのメールアドレスとユーザーネームとパスワードを表示したい ok
    public Optional<User> findById(Integer id) { // DBのINTに合わせてIntegerに変更
        return jdbcClient.sql("SELECT id, mail, name, password, reviewed FROM User WHERE id = :id")
                .param("id", id)
                .query(User.class)
                .optional();
    }


    // メールアドレスの重複チェック ok
    public boolean existsByMail(String mail) {
        Integer count = jdbcClient.sql("SELECT COUNT(*) FROM User WHERE mail = :mail")
                .param("mail", mail)
                .query(Integer.class)
                .single();
        return count != null && count > 0;
    }

    // メールアドレスからユーザー情報を取得 ok
    public Optional<User> findByMail(String mail){
        return jdbcClient.sql("SELECT id, mail, name, password, reviewed FROM User WHERE mail = :mail")
            .param("mail", mail)    
            .query(User.class)
            .optional();
    }

    // マイページのクーポン一覧から、店舗詳細へ
    public Optional<Store> viewCoupon(Integer id) {
        return jdbcClient.sql(
                "SELECT id,name,email,password,address,phone_number,payment,price_range,genre,coupon,free_desc FROM Store")
                .param("id", id)
                .query(Store.class)
                .optional();
    }

    // クーポン一覧の表示 ok
    // サービスから渡されたfindByIdCouponを実行
    public List<Store> findByIdCoupon() {
        return jdbcClient.sql(
                "SELECT id,name,email,password,address,phone_number,payment,price_range,genre,coupon,free_desc FROM Store")
                // データベースからいったん全部をとる
                .query(Store.class)// データベースからとってきた値(クーポン)をStore.classの形にする
                .list();// データベースからとってきた値(クーポン)をリストにする
    }


}
