package com.example.macaron;

public class StoreReview {
    private final Long id;
    private final int store_id;
    private final String comments;
    private final boolean evaluation;
    private final String user_id;

    public StoreReview(Long id, int store_id, String comments, boolean evaluation, String user_id) {
        this.id = id;
        this.store_id = store_id;
        this.comments = comments;
        this.evaluation = evaluation;
        this.user_id = user_id;
    }

    public Long getId() {
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

}
