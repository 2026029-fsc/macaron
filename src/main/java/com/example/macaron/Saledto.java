package com.example.macaron;

import java.util.List;

public class Saledto {
    private  List<Saleview> sale;
    private  List<SuddenSaleview> ssale;

    public Saledto(List<Saleview> sale, List<SuddenSaleview> ssale) {
        this.sale = sale;
        this.ssale = ssale;
    }

    public Saledto() {
    }

    public List<Saleview> getSale() {
        return sale;
    }
    public List<SuddenSaleview> getSsale() {
        return ssale;
    }

}
