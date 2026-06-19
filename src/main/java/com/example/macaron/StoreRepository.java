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

    //ホーム用広告
    // public List<Storeview> previewAd() {
    //     return jdbcClient.sql("SELECT F.id, name, email, password, address, phone_number, payment, price_range, genre, coupon, free_desc FROM Store AS F JOIN (SELECT CEIL (RAND() * (SELECT COUNT(*) FROM Store)) AS id ) AS Second WHERE F.id >= Second.id ORDER BY F.id ASC LIMIT 1")
    //             .query(Storeview.class)
    //             .list();
    // }

    //詳細表示
    // public Optional<Storeview> previewStore(Long id) {
    //     return jdbcClient.sql("SELECT id, name, email, password, address, phone_number, payment, price_range, genre, coupon, free_desc FROM Store WHERE id = :id")
    //             .param("id", id)
    //             .query(Storeview.class)
    //             .optional();
    // }

    //西山
    public Optional<Storeview> previewStore(Long id){
        return jdbcClient.sql("SELECT * FROM Store WHERE id = :id")
            .param("id",id)
            .query(Storeview.class)
            .optional();
    }
    
    //迎田祐圭
    public List<Storeview> previewStorehome(){
        return jdbcClient.sql("SELECT * FROM Store LIMIT 3")
            .query(Storeview.class)
            .list();
    }

    public List<Storeview> previewSStorehome(){
        return jdbcClient.sql("SELECT * FROM Store ORDER BY id DESC LIMIT 3")
            .query(Storeview.class)
            .list();
    }

    public List<Storeview> previewAd() {
        return jdbcClient.sql("SELECT F.id, name, email, password, address, phone_number, payment, price_range, genre, coupon, free_desc FROM Store AS F JOIN (SELECT CEIL (RAND() * (SELECT COUNT(*) FROM Store)) AS id ) AS Second WHERE F.id >= Second.id ORDER BY F.id ASC LIMIT 1")
                .query(Storeview.class)
                .list();
    }


}
