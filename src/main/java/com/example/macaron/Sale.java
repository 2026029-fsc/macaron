package com.example.macaron;

public class Sale {
    private final Long id;
    private final Integer store_id;
    private final String name;
    private final String contents;

    public Sale(Long id, Integer store_id, String name, String contents) {
        this.id = id;
        this.store_id = store_id;
        this.name = name;
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }
    public Integer getStore_id() {
        return store_id;
    }
    public String getName() {
        return name;
    }
    public String getContents() {
        return contents;
    }


}
