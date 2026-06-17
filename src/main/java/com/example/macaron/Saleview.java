package com.example.macaron;

//Sale.id, Sale.name, Store.name
public class Saleview {
    private final Integer id;
    private final String saleName;
    private final String storeName;

    public Saleview(Integer id, String saleName, String storeName) {
        this.id = id;
        this.saleName = saleName;
        this.storeName = storeName;
    }

    public Integer getId() {
        return id;
    }
    public String getSaleName() {
        return saleName;
    }
    public String getStoreName() {
        return storeName;
    }
}
