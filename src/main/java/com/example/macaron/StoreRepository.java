package com.example.macaron;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRepository {
    private JdbcClient jdbcClient;

    public StoreRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Optional<Store> previewStore(Long id){
        return jdbcClient.sql("SELECT * FROM Store WHERE id = :id")
            .param("id",id)
            .query(Store.class)
            .optional();
    }

    // public List<Storeview> previewAd() {
    //     return jdbcClient.sql("SELECT F.id, name FROM Store AS F JOIN (SELECT CEIL (RAND() * (SELECT COUNT(*) FROM Store)) AS id ) AS Second WHERE F.id >= Second.id ORDER BY F.id ASC LIMIT 1")
    //             .query(Storeview.class)
    //             .list();

    // }
    
}
