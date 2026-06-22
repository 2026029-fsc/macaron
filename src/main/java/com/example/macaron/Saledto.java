package com.example.macaron;

import java.util.List;

public class Saledto {
    private  List<SuddenSaleview> ssale;
    private final List<Storeview> store;
    private final List<Saleview> sale;


    public Saledto(List<Saleview> sale, List<SuddenSaleview> ssale, List<Storeview> store) {
        this.sale = sale;
        this.ssale = ssale;
        this.store = store;
    }

    public List<Storeview> getStore() {
        return store;
    }
    public List<Saleview> getSale() {
        return sale;
    }
    public List<SuddenSaleview> getSsale() {
        return ssale;
    }

}
