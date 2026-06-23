package com.example.macaron;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.log.SystemLogHandler;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRepository {
    private final JdbcClient jdbcClient;

    public StoreRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // public void updateStore(Integer id, String email, String name, String address, Long phone_number,
    //         String payment, String genre, Integer price_range, String free_desc, String coupon) {
    //     jdbcClient.sql(
    //             "UPDATE Store SET  email = :email, name = :name, address = :address, phone_number = :phone_number, payment = :payment, genre = :genre, price_range = :price_range, free_desc = :free_desc,coupon = :coupon WHERE id = :id")
    //             .param("id", id)
    //             .param("email", email)
    //             .param("name", name)
    //             .param("address", address)
    //             .param("phone_number", phone_number)
    //             .param("payment", payment)
    //             .param("genre", genre)
    //             .param("price_range", price_range)
    //             .param("free_desc", free_desc)
    //             .param("coupon", coupon)
    //             .update();
    // }

    //店舗編集機能
    public void updateStore(Integer id, String email, String name, String address, Long phone_number,
            String payment, String genre, Integer price_range, String free_desc, String coupon) {
        jdbcClient.sql(
                "UPDATE Store SET  name = :name, address = :address, phone_number = :phone_number, payment = :payment, genre = :genre, price_range = :price_range, free_desc = :free_desc,coupon = :coupon WHERE id = :id")
                .param("id",id)
                .param("name", name)
                .param("address", address)
                .param("phone_number", phone_number)
                .param("payment", payment)
                .param("genre", genre)
                .param("price_range", price_range)
                .param("free_desc", free_desc)
                .param("coupon", coupon)
                .update();
    }

    //Emailを表示するのみ
    public List<Email> previewEmail(Integer id) {
        return jdbcClient.sql("SELECT email FROM Store WHERE id = :id")
        .param("id",id)
        .query(Email.class)
        .list();
    }

    
//恒常セール
    public void updateSale(Integer id,String name, String contents) {
        jdbcClient.sql(" UPDATE Sale SET store_id = :id, name = :name, contents = :contents WHERE id = :id ")
                .param("id", id)
                // .param("store_id", store_id)
                .param("name", name)
                .param("contents", contents)
                .update();

    }

    //突発セール
    public void updateSuddenSale(Integer id, Integer store_id, String name, String contents) {
        jdbcClient.sql(
                "INSERT INTO SuddenSale (store_id, name, contents) VALUES ( :store_id, :name ,:contents)")
                .param("id", id)
                .param("store_id", store_id)
                .param("name", name)
                .param("contents", contents)
                .update();
    }

    public List<SuddenSale> findAll() {
        return jdbcClient.sql("SELECT id,store_id, name , contents,  completed FROM Suddensale")
                .query(SuddenSale.class)
                .list();
    }

    public void switchSuddenSale(Integer id) {
        jdbcClient.sql("UPDATE Suddensale SET completed = NOT completed WHERE store_id = :id")
                .param("id", id)
                .update();
    }

    public Optional<Store> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM Store WHERE id = :id")
                .param("id", id)
                .query(Store.class)
                .optional();
    }
    // public interface SuddensaleRepository extends JpaRepository<Suddensale, Long>
    // {
    // }

}
