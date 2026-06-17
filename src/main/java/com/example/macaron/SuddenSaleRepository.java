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
    public List<SuddenSaleview> previewSuddenSale() {
        return jdbcClient.sql("SELECT Suddensale.id, Suddensale.name AS suddensaleName, Store.name AS storeName FROM Suddensale JOIN Store ON Suddensale.store_id = Store.id LIMIT 3")
                .query(SuddenSaleview.class)
                .list();
    }

    //SuddenSale情報をジャンル検索
    public List<SuddenSaleview> storeSerch(String keyword) {
        return jdbcClient.sql("SELECT Suddensale.id, Suddensale.name AS suddensaleName, Store.name AS storeName FROM Suddensale JOIN Store ON Suddensale.store_id = Store.id WHERE genre LIKE :keyword LIMIT 3")
                .param("keyword", "%" + keyword + "%")
                .query(SuddenSaleview.class)
                .list();
    }
}
