package com.example.macaron;


//編集するためにfinalなし
public class SaleForm {
    // private int id;
    private int store_id;
    private String name;
    private String contents;


    // public SaleForm(int id, int store_id, String name, String contents) {
    //     this.id = id;
    //     this.store_id = store_id;
    //     this.name = name;
    //     this.contents = contents;
    // }


    // public int getId() {
    //     return id;
    // }
    public int getStore_id() {
        return store_id;
    }
    public String getName() {
        return name;
    }
    public String getContents() {
        return contents;
    }


    // public void setId(int id) {
    //     this.id = id;
    // }
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


