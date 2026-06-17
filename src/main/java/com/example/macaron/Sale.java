package com.example.macaron;

public class Sale {
    private final Long id;
    private final int store_id;
    private final String name;
    private final String contents;

    public Sale(int id, int store_id, String name, String contents) {
        this.id = id;
        this.store_id = store_id;
        this.name = name;
        this.contents = contents;
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


}
