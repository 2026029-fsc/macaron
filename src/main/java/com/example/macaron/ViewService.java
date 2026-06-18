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

    // Sale情報の表示
    // public Saledto previewSale() {
    //     List<Saleview> sale = saleRepository.previewSale();
    //     List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
    //     List<Storeview> store = storeRepository.previewAd();
    //     return new Saledto(sale, ssale, store);
    // };

    // Sale情報をジャンル検索
    // public Saledto serchByGenre(String keyword) {
    //     if (keyword == null || keyword.isBlank()) {
    //         List<Saleview> sale = saleRepository.previewSale();
    //         List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
    //         List<Storeview> store = storeRepository.previewAd();
    //         return new Saledto(sale, ssale, store);
    //     } else {
    //         List<Saleview> sale = saleRepository.serchByGenre(keyword);
    //         List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
    //         List<Storeview> store = storeRepository.previewAd();
    //         return new Saledto(sale, ssale, store);
    //     }
    // }

    public List<Saleview> saleserchByGenre(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return saleRepository.previewSale();
        } else {
            return saleRepository.searchByKeyword(keyword);
        }
    }

    // Sale情報をキーワード検索
    // public Saledto saleserchByKeyword(String keyword) {
    //     if (keyword == null || keyword.isBlank()) {
    //         List<Saleview> sale = saleRepository.previewSale();
    //         List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
    //         List<Storeview> store = storeRepository.previewAd();
    //     return new Saledto(sale, ssale, store);
    //     } else {
    //         List<Saleview> sale = saleRepository.searchByKeyword(keyword);
    //         List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
    //         List<Storeview> store = storeRepository.previewAd();
    //     return new Saledto(sale, ssale, store);
    //     }
    // }

    public List<Saleview> saleserchByKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return saleRepository.previewSale();
        } else {
            return saleRepository.searchByKeyword(keyword);
        }
    }

    // SuddenSale情報の表示
    // public List<SuddenSaleview> previewSuddenSale() {
    //     return suddensaleRepository.previewSuddenSale();
    // }

    // SuddenSale情報をジャンル検索
    // public List<SuddenSaleview> storeSuddenSaleSerch(String keyword) {
    //     if (keyword == null || keyword.isBlank()) {
    //         return suddensaleRepository.previewSuddenSale();
    //     } else {
    //         return suddensaleRepository.serchByGenre(keyword);
    //     }
    // }

    // SuddenSaleをキーワード検索
    // public List<SuddenSaleview> suudensaleserchByKeyword(String keyword) {
    //     if (keyword == null || keyword.isBlank()) {
    //         return suddensaleRepository.previewSuddenSale();
    //     } else {
    //         return suddensaleRepository.serchByKeyword(keyword);
    //     }
    // }

    // //店舗詳細への遷移
    // public Optional<Storeview> storeDetailById(Long id) {
    //     return storeRepository.storeDetailById(id);
    // }

    // //sale店舗詳細への遷移
    // public Optional<Saleview> saleDetailById(Long id) {
    //     return saleRepository.saleDetailById(id);
    // }

    // //suddensale店舗詳細への遷移
    // public Optional<SuddenSaleview> suddensalDetailById(Long id) {
    //     return suddensaleRepository.suddensaleDetailById(id);
    // }

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
    public List<Saleview> sale() {
        return saleRepository.previewSale();
    }
    public List<SuddenSaleview> suddensale() {
        return suddensaleRepository.previewSuddenSale();
    }
    public List<Storeview> previewAd() {
        return storeRepository.previewAd();
    };

}
