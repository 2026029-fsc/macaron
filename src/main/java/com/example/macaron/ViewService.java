package com.example.macaron;

import java.util.List;
import java.util.Optional;

// import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

@Service
public class ViewService {
    private final StoreRepository storeRepository;
    private final SuddenSaleRepository suddensaleRepository;
    private final SaleRepository saleRepository;
    private final StoreReviewRepository storeReviewRepository;

    public ViewService(StoreRepository storeRepository,SuddenSaleRepository suddensaleRepository, SaleRepository saleRepository, StoreReviewRepository storeReviewRepository) {
        this.storeRepository = storeRepository;
        this.suddensaleRepository = suddensaleRepository;
        this.saleRepository = saleRepository;
        this.storeReviewRepository = storeReviewRepository;
    }

    // // Sale情報の表示
    // public Saledto previewSale() {
    //     List<Saleview> sale = saleRepository.previewSale();
    //     List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
    //     return new Saledto(sale, ssale);
    // };

    // Sale情報をジャンル検索
    public Saledto serchByGenre(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            List<Saleview> sale = saleRepository.previewSale();
            List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
            List<Storeview> store = storeRepository.previewAd();
            return new Saledto(sale, ssale, store);
        } else {
            List<Saleview> sale = saleRepository.dtoserchByGenre(keyword);
            List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
            List<Storeview> store = storeRepository.previewAd();
            return new Saledto(sale, ssale, store);
        }
    }

    //Sale情報をキーワード検索
    public Saledto saleserchByKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            List<Saleview> sale = saleRepository.previewSale();
            List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
            List<Storeview> store = storeRepository.previewAd();
            return new Saledto(sale, ssale, store);
        } else {
            List<Saleview> sale = saleRepository.dtosearchByKeyword(keyword);
            List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
            List<Storeview> store = storeRepository.previewAd();
            return new Saledto(sale, ssale, store);
        }
    }

    //西山 店舗情報の詳細表示 Store、Sale、SSale、Review
    public Optional<Storeview> StoreDetailId(Integer id) {
        return storeRepository.previewStore(id);
    };
    public List<Saleview> SaleDetailId(Integer id) {
        return saleRepository.previewSaleForId(id);
    };
    public List<SuddenSaleview> SSaleDetailId(Integer id) {
        return suddensaleRepository.previewSuddenSaleForId(id);
    };
    public List<Review> reviews(Integer id){
        return storeReviewRepository.previewSaleForId(id);
    }

    //迎田祐圭
    //Sale view
    public List<Saleview> sale() {
        return saleRepository.previewSale();
    }
    //SuddenSale view
    public List<SuddenSaleview> suddensale() {
        return suddensaleRepository.previewSuddenSale();
    }
    //Advertisement Store
    public List<Storeview> previewAd() {
        return storeRepository.previewAd();
    }

}
