package com.example.macaron;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreSubmitService {
    private final StoreRepository storeRepository;

    public StoreSubmitService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    // public void editstore( String name, String address, int phone_number, String
    // payment, String genre,
    // int price_range, String free_desc, String coupon) {
    // Store store = new Store();
    // store.setName(name);
    // store.setAddress(address);
    // store.setPhone_number(phone_number);
    // store.setPayment(payment);
    // store.setGenre(genre);
    // store.setPrice_range(price_range);
    // store.setFree_desc(Free_desc);
    // store.setCoupon(coupon);

    // storeRepository.save(store);

    // }
    public void updateStore(Long id, StoreForm form) {
        storeRepository.updateStore(id, form.getEmail(), form.getName(), form.getAddress(), form.getPhone_number(),
                form.getPayment(), form.getGenre(), form.getPrice_range(), form.getCoupon(), form.getFree_desc());
    }

    public void updateSale(Long id, SaleForm form) {
        storeRepository.updateSale(id, form.getStore_id(), form.getName(), form.getContents());
    }
}
