package com.example.macaron;

// 西山 店舗詳細に表示するレビューのクラス(レビューとユーザー、店舗のテーブルを結合)
public class Review {
  private final String name;
  private final Integer store_id;
  private final String comments;
  private final boolean evaluation;

  public Review(String name, int store_id, String comments, boolean evaluation) {
    this.name = name;
    this.store_id = store_id;
    this.comments = comments;
    this.evaluation = evaluation;
  }

  public String getComments() {
    return comments;
  }
  public String getName() {
    return name;
  }
  public boolean getEvaluation(){
    return evaluation;
  }
  public int getStore_id() {
    return store_id;
  }


}
