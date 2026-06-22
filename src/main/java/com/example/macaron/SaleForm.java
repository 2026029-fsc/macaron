package com.example.macaron;

//編集するためにfinalなし
public class SaleForm {
    private int store_id;
    private String name;
    private String contents;


    public int getStore_id() {
        return store_id;
    }
    public String getName() {
        return name;
    }
    public String getContents() {
        return contents;
    }
    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    public void setContents(String contents) {
        this.contents = contents;
    }
}










