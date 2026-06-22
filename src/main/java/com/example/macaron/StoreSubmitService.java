package com.example.macaron;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StoreSubmitService {
    private final SuddenSaleRepository suddenSaleRepository;
    private final StoreRepository storeRepository;
    private final SaleRepository saleRepository;

    public StoreSubmitService(StoreRepository storeRepository, SaleRepository saleRepository, SuddenSaleRepository suddenSaleRepository) {
        this.storeRepository = storeRepository;
        this.saleRepository = saleRepository;
        this.suddenSaleRepository = suddenSaleRepository;
    }

    public void updateStore(Integer id, StoreForm form) {
        storeRepository.updateStore(id, form.getEmail(), form.getName(), form.getAddress(), form.getPhone_number(),
                form.getPayment(), form.getGenre(), form.getPrice_range(), form.getCoupon(), form.getFree_desc());
    }

    public void updateSale(Integer id, SaleForm form) {
        storeRepository.updateSale(id,  form.getName(), form.getContents());
    }

    //突発セール投稿
    public void updateSuddenSale(Integer id, SuddenSaleForm form) {
        suddenSaleRepository.updateSuddenSale(new SuddenSale(null, id, form.getName(), form.getContents(), false));
    }

    public List<SuddenSale> showSuddensale() {
        return storeRepository.findAll();
    }

    public void switchSuddenSale(Integer id) {
        storeRepository.switchSuddenSale(id);
    }

    public Optional<Store> findById(Integer id) {
        return storeRepository.findById(id);
    }

    public List<Email> previewEmail(Integer id) {
        return storeRepository.previewEmail(id);
    }

    public Optional<IdSale> editSale(Integer id) {
        return saleRepository.editSale(id);
    }

    public List<SuddenSaleview> previewSuddenSaleForstoreId(Integer id) {
        return suddenSaleRepository.previewSuddenSaleForstoreId(id);
    }
    // @Autowired
    // private SuddensaleRepository repository;

    // public List<Suddensale> findAll() {
    // return repository.findAll();
    // }
}
