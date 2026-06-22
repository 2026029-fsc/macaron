package com.example.macaron;

public class StoreReview {
    private final Integer id;
    private final Integer store_id;
    private final String comments;
    private final boolean evaluation;
    private final String user_id;

    public StoreReview(Integer id, Integer store_id, String comments, boolean evaluation, String user_id) {
        this.id = id;
        this.store_id = store_id;
        this.comments = comments;
        this.evaluation = evaluation;
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }
    public Integer getStore_id() {
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

}
