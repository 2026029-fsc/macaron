package com.example.macaron;

//パスワード、クーポン、自由記述が編集可能
public class Store {
    private final Integer id;
    private final String name;
    private final String email;
    private String password;
    private final String address;
    private final Integer phone_number;
    private final String payment;
    private final Integer price_range;
    private final String genre;
    private String coupon;
    private String free_desc;

    public Store(Integer id, String name, String email, String password, String address, Integer phone_number, String payment,
            Integer price_range, String genre, String coupon, String free_desc) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone_number = phone_number;
        this.payment = payment;
        this.price_range = price_range;
        this.genre = genre;
        this.coupon = coupon;
        this.free_desc = free_desc;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

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

    public void setPassword(String password) {
        this.password = password;
    }
    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
    public void setFree_desc(String free_desc) {
        this.free_desc = free_desc;
    }


}
