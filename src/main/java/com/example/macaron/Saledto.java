package com.example.macaron;

import java.util.List;

public class Saledto {
    private  List<Saleview> sale;
    private  List<SuddenSaleview> ssale;
    private  List<Storeview> store;

    public Saledto(List<Saleview> sale, List<SuddenSaleview> ssale, List<Storeview> store) {
        this.sale = sale;
        this.ssale = ssale;
        this.store = store;
    }

    public Saledto() {
    }

    public List<Saleview> getSale() {
        return sale;
    }
    public List<SuddenSaleview> getSsale() {
        return ssale;
    }
    public List<Storeview> getStore() {
        return store;
    }

}
