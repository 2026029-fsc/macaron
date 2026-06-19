package com.example.macaron;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class SuddenSaleRepository {

    private JdbcClient jdbcClient;

    public SuddenSaleRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    //SuddenSale情報の表示
    // public List<SuddenSaleview> previewSuddenSale() {
    //     return jdbcClient.sql("SELECT Suddensale.id AS id, Suddensale.name AS suddensaleName, Store.name AS storeName FROM Suddensale JOIN Store ON Suddensale.store_id = Store.id LIMIT 3")
    //             .query(SuddenSaleview.class)
    //             .list();
    // }

    //SuddenSale情報をジャンル検索
    // public List<SuddenSaleview> serchByGenre(String keyword) {
    //     return jdbcClient.sql("SELECT Suddensale.id AS id, Suddensale.name AS suddensaleName, Store.name AS storeName FROM Suddensale JOIN Store ON Suddensale.store_id = Store.id WHERE genre LIKE :keyword LIMIT 3")
    //             .param("keyword", "%" + keyword + "%")
    //             .query(SuddenSaleview.class)
    //             .list();
    // }

    //SuddenSale情報をキーワード検索
    // public List<SuddenSaleview> serchByKeyword(String keyword) {
    //     return jdbcClient.sql("SELECT Suddensale.id AS id, Suddensale.name AS suddensaleName, Store.name AS storeName FROM Suddensale JOIN Store ON Suddensale.store_id = Store.id WHERE genre LIKE :keyword LIMIT 3")
    //             .param("keyword", "%" + keyword + "%")
    //             .query(SuddenSaleview.class)
    //             .list();
    // }

    // //詳細表示
    // public Optional<SuddenSaleview> suddensaleDetailById(Long id) {
    //     return jdbcClient.sql("SELECT id, name AS storeName, email, password, address, phone_number, payment, price_range, genre, coupon, free_desc FROM Store WHERE id = :id")
    //             .param("id", id)
    //             .query(SuddenSaleview.class)
    //             .optional();
    // }

    // idで1店舗のみに絞り込んで SuddenSale情報の表示(Storeテーブルとの結合なし)
    public List<SuddenSaleview> previewSuddenSaleForId(Long id) {
        return jdbcClient.sql("SELECT * FROM Suddensale WHERE id = :id ")
                .param("id",id)
                .query(SuddenSaleview.class)
                .list();
    }

    //迎田祐圭
    public List<SuddenSaleview> previewSuddenSale() {
        return jdbcClient.sql("SELECT * FROM Suddensale ORDER BY id DESC LIMIT 3 ")
                .query(SuddenSaleview.class)
                .list();
    }
    public List<SuddenSaleview> serchByKeyword(String keyword) {
        return jdbcClient.sql("SELECT * FROM Suddensale  WHERE genre LIKE :keyword ORDER BY id DESC LIMIT 3")
                .param("keyword", "%" + keyword + "%")
                .query(SuddenSaleview.class)
                .list();
    }

}
