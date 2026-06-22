package com.example.macaron;

//編集するためにfinalなし
public class StoreForm {
    // private int id;
    private String name;
    private String email;
    // private String password;
    private String address;
    private Long phone_number;
    private String payment;
    private int price_range;
    private String genre;
    private String coupon;
    private String free_desc;

    public StoreForm() {
    }
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

    public Long getPhone_number() {
        return phone_number;
    }

    public String getPayment() {
        return payment;
    }

    public int getPrice_range() {
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
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }
    public void setPrice_range(int price_range) {
        this.price_range = price_range;
    }

}
