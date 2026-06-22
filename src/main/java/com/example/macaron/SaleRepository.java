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

    //無理やりSaleviewClassに格納
    public List<Saleview> dtoserchByGenre(String keyword) {
        return jdbcClient.sql("SELECT Sale.id AS id, Sale.store_id, Sale.name AS name, Store.name AS contents FROM Store JOIN Sale ON Store.id = Sale.store_id WHERE genre LIKE :keyword")
                .param("keyword", "%" + keyword + "%")
                .query(Saleview.class)
                .list();
    }

    //Sale情報をキーワード検索

    public List<Saleview> dtosearchByKeyword(String keyword) {
        return jdbcClient.sql("SELECT Sale.id AS id, Sale.store_id, Sale.name AS name, Store.name AS contents FROM Sale JOIN Store ON Store.id = Sale.store_id WHERE Sale.name LIKE :keyword")
                .param("keyword", "%" + keyword + "%")
                .query(Saleview.class)
                .list();
    }

    public Optional<Saleview> saleDetailById(Long id) {
        return jdbcClient.sql("SELECT * FROM Store WHERE id = :id")
                .param("id", id)
                .query(Saleview.class)
                .optional();
    }

    //西山 idで絞り込んでのSale情報の表示(Storeテーブルとの結合なし)
    public List<Saleview> previewSaleForId(Long id) {
        return jdbcClient.sql("SELECT * FROM Sale WHERE id = :id ")
                .param("id",id)
                .query(Saleview.class)
                .list();
    }

    //迎田祐圭
    public List<Saleview> previewSale() {
        return jdbcClient.sql("SELECT Sale.id AS id, Sale.store_id, Sale.name AS name, Store.name AS contents FROM Store JOIN Sale ON Store.id = Sale.store_id ")
                .query(Saleview.class)
                .list();
    }
    
}
