package com.example.macaron;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

//西山 店舗レビューのリポジトリ

@Repository
public class StoreReviewRepository {

  private final JdbcClient jdbcClient;

  public StoreReviewRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  // idで絞り込んでのSale情報の表示(Storeテーブルとの結合なし)
  public List<Review> previewSaleForId(Long id) {
    return jdbcClient.sql("SELECT User.name AS name, Store.id AS store_id, StoreReview.comments AS comments, StoreReview.evaluation AS evaluation FROM Store JOIN StoreReview ON Store.id = StoreReview.store_id RIGHT JOIN User ON User.id = StoreReview.user_id WHERE Store.id = :id")
        .param("id", id)
        .query(Review.class)
        .list();
  }

}
