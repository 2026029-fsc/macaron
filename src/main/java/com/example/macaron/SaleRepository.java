package com.example.macaron;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class SaleRepository {

    private JdbcClient jdbcClient;

    public SaleRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    //Sale情報の表示
    public List<Saleview> previewSale() {
        return jdbcClient.sql("SELECT Sale.id, Sale.name AS saleName, Store.name AS storeName FROM Sale JOIN Store ON Sale.store_id = Store.id LIMIT 3")
                .query(Saleview.class)
                .list();
    }

    //西山 idで絞り込んでのSale情報の表示(Storeテーブルとの結合なし)
    public List<Sale> previewSaleForId(Long id) {
        return jdbcClient.sql("SELECT * FROM Sale WHERE id = :id ")
                .param("id",id)
                .query(Sale.class)
                .list();
    }

    //Sale情報をジャンル検索
    public List<Saleview> serchByGenre(String keyword) {
        return jdbcClient.sql("SELECT Sale.id, Sale.name AS saleName, Store.name AS storeName FROM Sale JOIN Store ON Sale.store_id = Store.id WHERE Store.genre LIKE :keyword LIMIT 3")
                .param("keyword", "%" + keyword + "%")
                .query(Saleview.class)
                .list();
    }

    //Sale情報をキーワード検索
    public List<Saleview> searchByKeyword(String keyword) {
        return jdbcClient.sql("SELECT Sale.id, Sale.name AS saleName, Store.name AS storeName FROM Sale JOIN Store ON Sale.store_id = Store.id WHERE Sale.name LIKE :keyword")
                .param("keyword", "%" + keyword + "%")
                .query(Saleview.class)
                .list();
    }
    
}
