package com.example.macaron;


//SuddenSale.id, SuddenSale.name, Store.name
public class SuddenSaleview {
    private final Integer id;
    private final String suddensaleName;
    private final String storeName;


    public SuddenSaleview(Integer id, String suddensaleName, String storeName) {
        this.id = id;
        this.suddensaleName = suddensaleName;
        this.storeName = storeName;
    }

    public Integer getId() {
        return id;
    }
    public String getSuddensaleName() {
        return suddensaleName;
    }
    public String getStoreName() {
        return storeName;
    }
    
}
