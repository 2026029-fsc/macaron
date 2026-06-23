package com.example.macaron;

import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class SaleRepository {
    private JdbcClient jdbcClient;

    public SaleRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Optional<IdSale> editSale(Integer id) {
        return jdbcClient.sql("SELECT name, contents FROM Sale WHERE store_id = :id")
        .param("id",id)
        .query(IdSale.class)
        .optional();
    }
}
