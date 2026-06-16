package com.example.macaron;

//completedのみ編集可能
public class SuddenSale {
    private final int id;
    private final int store_id;
    private final String name;
    private final String contents;
    private final boolean completed;

    public SuddenSale(int id, int store_id, String name, String contents, boolean completed) {
        this.id = id;
        this.store_id = store_id;
        this.name = name;
        this.contents = contents;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }
    public int getStore_id() {
        return store_id;
    }
    public String getName() {
        return name;
    }
    public String getContents() {
        return contents;
    }
    public boolean getCompleted() {
        return completed;
    }
 
}
