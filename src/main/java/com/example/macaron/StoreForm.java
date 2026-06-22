package com.example.macaron;

//編集するためにfinalなし
public class StoreForm {
    // private int id;
    private String name;
    private String email;
    // private String password;
    private String address;
    private Integer phone_number;
    private String payment;
    private Integer price_range;
    private String genre;
    private String coupon;
    private String free_desc;

    // public StoreForm(int id, String name, String email, String password, String
    // address, int phone_number, String payment,
    // int price_range, String genre, String coupon, String free_desc) {
    // this.id = id;
    // this.name = name;
    // this.email = email;
    // this.password = password;
    // this.address = address;
    // this.phone_number = phone_number;
    // this.payment = payment;
    // this.price_range = price_range;
    // this.genre = genre;
    // this.coupon = coupon;
    // this.free_desc = free_desc;
    // }

    // public int getId() {
    // return id;
    // }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // public String getPassword() {
    // return password;
    // }

    public String getAddress() {
        return address;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public String getPayment() {
        return payment;
    }

    public Integer getPrice_range() {
        return price_range;
    }

    public String getGenre() {
        return genre;
    }

    public String getCoupon() {
        return coupon;
    }

    public String getFree_desc() {
        return free_desc;
    }

    // public void setPassword(String password) {
    // this.password = password;
    // }
    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public void setFree_desc(String free_desc) {
        this.free_desc = free_desc;
    }

}
