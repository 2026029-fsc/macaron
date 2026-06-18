package com.example.macaron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreSubmitService {
    private final StoreRepository storeRepository;

    public StoreSubmitService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void updateStore(Long id, StoreForm form) {
        storeRepository.updateStore(id, form.getEmail(), form.getName(), form.getAddress(), form.getPhone_number(),
                form.getPayment(), form.getGenre(), form.getPrice_range(), form.getCoupon(), form.getFree_desc());
    }

    public void updateSale(Long id, SaleForm form) {
        storeRepository.updateSale(id, form.getStore_id(), form.getName(), form.getContents());
    }

    public void updateSuddenSale(Long id, SuddenSaleForm form) {
        storeRepository.updateSuddenSale(id, form.getStore_id(), form.getName(), form.getContents());
    }

    @Autowired
    private StoreRepository StoreRepository;

    public List<SuddenSale> showSuddensale() {
        return StoreRepository.findAll();
    }

    public void switchSuddenSale(Long id) {
        StoreRepository.switchSuddenSale(id);
    }
    // @Autowired
    // private SuddensaleRepository repository;

    // public List<Suddensale> findAll() {
    // return repository.findAll();
    // }
}
