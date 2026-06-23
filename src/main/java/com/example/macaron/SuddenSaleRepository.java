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

    // idで1店舗のみに絞り込んで SuddenSale情報の表示(Storeテーブルとの結合なし)
    public List<SuddenSaleview> previewSuddenSaleForId(Integer id) {
        return jdbcClient.sql("SELECT * FROM Suddensale WHERE id = :id ")
                .param("id", id)
                .query(SuddenSaleview.class)
                .list();
    }

    // 迎田祐圭
    public List<SuddenSaleview> serchByKeyword(String keyword) {
        return jdbcClient.sql("SELECT * FROM Suddensale  WHERE genre LIKE :keyword ORDER BY id DESC LIMIT 3")
                .param("keyword", "%" + keyword + "%")
                .query(SuddenSaleview.class)
                .list();
    }

    public List<SuddenSaleview> previewSuddenSale() {
        return jdbcClient.sql(
                "SELECT Suddensale.id AS id, Suddensale.store_id, Suddensale.name AS name, Store.name AS contents, completed FROM Store JOIN Suddensale ON Store.id = Suddensale.store_id ORDER BY id DESC LIMIT 3")
                .query(SuddenSaleview.class)
                .list();
    }

    // 菰方貴大
    public void updateSuddenSale(SuddenSale suddensale) {
        jdbcClient.sql(
                "INSERT INTO Suddensale (store_id, name, contents, completed) VALUES ( :store_id, :name ,:contents, :completed)")
                .param("store_id", suddensale.getStore_id())
                .param("name", suddensale.getName())
                .param("contents", suddensale.getContents())
                .param("completed",suddensale.getCompleted())
                .update();
    }

    public List<SuddenSaleview> previewSuddenSaleForstoreId(Integer id) {
        return jdbcClient.sql("SELECT * FROM Suddensale WHERE store_id = :id AND completed = false ORDER BY Suddensale.id DESC")
                .param("id", id)
                .query(SuddenSaleview.class)
                .list();
    }

    // public void switchSuddenSale(Integer id) {
    //     jdbcClient.sql("UPDATE Suddensale SET completed = NOT completed WHERE id = :id")
    //             .param("id", id)
    //             .update();
    // }

    public void switchSuddenSale(Integer id) {
        jdbcClient.sql("UPDATE Suddensale SET completed = true WHERE id = :id")
        // jdbcClient.sql("DELETE FROM Suddensale WHERE id = :id")
                .param("id", id)
                .update();
    }

}