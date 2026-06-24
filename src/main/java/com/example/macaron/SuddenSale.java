package com.example.macaron;

//completedのみ編集可能
public class SuddenSale {
    private final Integer id;
    private final Integer store_id;
    private final String name;
    private final String contents;
    private final boolean completed;

    public SuddenSale(Integer id, Integer store_id, String name, String contents, boolean completed) {
        this.id = id;
        this.store_id = store_id;
        this.name = name;
        this.contents = contents;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }
    public Integer getStore_id() {
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
