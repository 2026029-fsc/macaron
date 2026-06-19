package com.example.macaron;

import java.util.List;

public class Saledto {
    // private  final Integer id;
    private  List<SuddenSaleview> ssale;
    // private  final String saleName;
    // private  final String storeName;
    private final List<Storeview> store;
    private final List<Saleview> sale;


    public Saledto(List<Saleview> sale, List<SuddenSaleview> ssale, List<Storeview> store) {
        this.sale = sale;
        this.ssale = ssale;
        this.store = store;
    }

    // public Saledto() {
    // }

    // public List<Saleview> getSale() {
    //     return sale;
    // }
    // public List<SuddenSaleview> getSsale() {
    //     return ssale;
    // }
    // public List<Storeview> getStore() {
    //     return store;
    // }

    //Sale.id AS id, Sale.name AS saleName, Store.name AS storeName
    // public Saledto(List<Storeview> store, List<Saleview> sale) {
    //     this.store = store;
    //     this.sale = sale;
    // }

    public List<Storeview> getStore() {
        return store;
    }
    public List<Saleview> getSale() {
        return sale;
    }
    public List<SuddenSaleview> getSsale() {
        return ssale;
    }

    // public Integer getId() {
    //     return id;
    // }
    // public String getSaleName() {
    //     return saleName;
    // }
    // public String getStoreName() {
    //     return storeName;
    // }


}
