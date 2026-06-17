package com.example.macaron;

//編集するためにfinalなし
public class StoreReviewForm {
    private int id;
    private int store_id;
    private String comments;
    private boolean evaluation;
    private String user_id;

    public StoreReviewForm(int id, int store_id, String comments, boolean evaluation, String user_id) {
        this.id = id;
        this.store_id = store_id;
        this.comments = comments;
        this.evaluation = evaluation;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }
    public int getStore_id() {
        return store_id;
    }
    public String getComments() {
        return comments;
    }
    public boolean getEvaluation() {
        return evaluation;
    }
    public String getUser_id() {
        return user_id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public void setEvaluation(boolean evaluation) {
        this.evaluation = evaluation;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}

//a