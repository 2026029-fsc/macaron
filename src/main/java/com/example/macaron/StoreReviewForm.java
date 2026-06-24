package com.example.macaron;

public class StoreReviewForm {
  private String comments;
  private String evaluation; //HTMLから返ってくる値がStringのため、送信するときにboolに変換
  private String user_id;

  public StoreReviewForm(String comments, String evaluation, String user_id) {
    this.comments = comments;
    this.evaluation = evaluation;
    this.user_id = user_id;
  }

  public String getComments() {
    return comments;
  }
  public String getUser_id() {
    return user_id;
  }
  public String getevaluation() {
    return evaluation;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }
  public void setEvaluation(String evaluation) {
    this.evaluation = evaluation;
  }
  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

}
