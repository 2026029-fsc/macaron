package com.example.macaron;

import java.util.List;

import org.apache.tomcat.util.log.SystemLogHandler;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRepository {
    private final JdbcClient jdbcClient;

    public StoreRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void updateStore(Long id, String email, String name, String address, int phone_number, String payment,
            String genre,
            int price_range, String free_desc, String coupon) {
        jdbcClient.sql(
                "INSERT INTO Store ( email, name, address, phone_number, payment, genre, price_range, free_desc,coupon) VALUES ( :name, :address, :phone_number, :payment, :genre, :price_range, :free_desc,:coupon)")
                .param("email", email)
                .param("name", name)
                .param("address", address)
                .param("phone_number", phone_number)
                .param("patment", payment)
                .param("genre", genre)
                .param("price_range", price_range)
                .param("free_desc", free_desc)
                .param("coupon", coupon)
                .update();
    }

    public void updateSale(Long id, int store_id, String name, String contents) {
        jdbcClient.sql(
                "INSERT INTO Sale ( store_id, name, contents) VALUES ( :store_id, :name :contents)")
                .param("store_id", store_id)
                .param("name", name)
                .param("contents", contents)
                .update();

    }

    public void updateSuddenSale(Long id, int store_id, String name, String contents) {
        jdbcClient.sql(
                "INSERT INTO SuddenSale (store_id, name, contents) VALUES ( :store_id, :name :contents)")
                .param("store_id", store_id)
                .param("name", name)
                .param("contents", contents)
                // .param("completed", completed)
                .update();
    }
}
