package com.example.macaron;

public class IdSale {
    private String name;
    private String contents;
    
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public IdSale(String name, String contents) {
        this.name = name;
        this.contents = contents;
    }

    public IdSale() {
        
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
