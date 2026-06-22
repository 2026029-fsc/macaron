package com.example.macaron;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ViewService {
    private final SuddenSaleRepository suddensaleRepository;
    private final SaleRepository saleRepository;
    private final StoreRepository storeRepository;
    private final StoreReviewRepository storeReviewRepository;

    public ViewService(SuddenSaleRepository suddensaleRepository, SaleRepository saleRepository,
            StoreRepository storeRepository, StoreReviewRepository storeReviewRepository) {
        this.suddensaleRepository = suddensaleRepository;
        this.saleRepository = saleRepository;
        this.storeRepository = storeRepository;
        this.storeReviewRepository = storeReviewRepository;
    }

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
    public Optional<Storeview> StoreDetailId(Long id) {
        return storeRepository.previewStore(id);
    };
    public List<Saleview> SaleDetailId(Long id) {
        return saleRepository.previewSaleForId(id);
    };
    public List<SuddenSaleview> SSaleDetailId(Long id) {
        return suddensaleRepository.previewSuddenSaleForId(id);
    };
    public List<Review> reviews(Long id){
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
