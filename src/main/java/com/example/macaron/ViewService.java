package com.example.macaron;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ViewService {
    private final SuddenSaleRepository suddensaleRepository;
    private final SaleRepository saleRepository;

    public ViewService(SuddenSaleRepository suddensaleRepository, SaleRepository saleRepository) {
        this.suddensaleRepository = suddensaleRepository;
        this.saleRepository = saleRepository;
    }

    // Sale情報の表示
    public Saledto previewSale() {
        List<Saleview> sale = saleRepository.previewSale();
        List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
        return new Saledto(sale, ssale);
    };

    // Sale情報をジャンル検索
    public Saledto serchByGenre(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            List<Saleview> sale = saleRepository.previewSale();
            List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
            return new Saledto(sale, ssale);
        } else {
            List<Saleview> sale = saleRepository.serchByGenre(keyword);
            List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
            return new Saledto(sale, ssale);
        }
    }

    // Sale情報をキーワード検索
    public Saledto saleserchByKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            List<Saleview> sale = saleRepository.previewSale();
            List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
            return new Saledto(sale, ssale);
        } else {
            List<Saleview> sale = saleRepository.searchByKeyword(keyword);
            List<SuddenSaleview> ssale = suddensaleRepository.previewSuddenSale();
            return new Saledto(sale, ssale);
        }
    }

    // SuddenSale情報の表示
    public List<SuddenSaleview> previewSuddenSale() {
        return suddensaleRepository.previewSuddenSale();
    }

    // SuddenSale情報をジャンル検索
    public List<SuddenSaleview> storeSuddenSaleSerch(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return suddensaleRepository.previewSuddenSale();
        } else {
            return suddensaleRepository.serchByGenre(keyword);
        }
    }

    // SuddenSaleをキーワード検索
    public List<SuddenSaleview> suudensaleserchByKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return suddensaleRepository.previewSuddenSale();
        } else {
            return suddensaleRepository.serchByKeyword(keyword);
        }
    }

}
