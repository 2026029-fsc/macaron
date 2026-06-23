package com.example.macaron;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class StoreSubmitService {
    private final SuddenSaleRepository suddenSaleRepository;
    private final StoreRepository storeRepository;
    private final SaleRepository saleRepository;
    private final PasswordEncoder passwordEncoder;


    public StoreSubmitService(StoreRepository storeRepository, SaleRepository saleRepository, SuddenSaleRepository suddenSaleRepository, PasswordEncoder passwordEncoder) {
        this.storeRepository = storeRepository;
        this.saleRepository = saleRepository;
        this.suddenSaleRepository = suddenSaleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean authenticate(String mail, String rawPassword) {
    // メールアドレスからユーザーを検索
        Optional<Store> storeOpt = storeRepository.findByMail(mail);
        if (storeOpt.isEmpty()) {
            return false; // ユーザーが存在しない
        }

        Store store = storeOpt.get();
    // 入力された生パスワードと、DBのハッシュ化パスワードを比較
        return passwordEncoder.matches(rawPassword, store.getPassword());
    }


    public void updateStore(Integer id, StoreForm form) {
        storeRepository.updateStore(id, form.getEmail(), form.getName(), form.getAddress(), form.getPhone_number(),
                form.getPayment(), form.getGenre(), form.getPrice_range(), form.getFree_desc(), form.getCoupon());
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
        suddenSaleRepository.switchSuddenSale(id);
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

    public List<SuddenSaleview> previewSuddenSaleForstoreIdfalse(Integer id) {
        return suddenSaleRepository.previewSuddenSaleForstoreIdfalse(id);
    }

    public List<SuddenSaleview> previewSuddenSaleForstoreId(Integer id) {
        return suddenSaleRepository.previewSuddenSaleForstoreId(id);
    }

    public Optional<Store> findByMail(String mail) {
        return storeRepository.findByMail(mail); 
    }
    
    // @Autowired
    // private SuddensaleRepository repository;

    // public List<Suddensale> findAll() {
    // return repository.findAll();
    // }
}
