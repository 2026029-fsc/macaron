package com.example.macaron;

public class Storeview {
    private final Integer id;
    private final String storeName;

    public Storeview(Integer id, String storeName) {
        this.id = id;
        this.storeName = storeName;
    }

    public Integer getId() {
        return id;
    }

    public String getStoreName() {
        return storeName;
    }
}
