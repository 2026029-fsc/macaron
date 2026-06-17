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

    //Sale情報の表示
    public List<Saleview> previewSale() {
        return saleRepository.previewSale();
    }

    //Sale情報をジャンル検索
    public List<Saleview> storeSaleSerch(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return saleRepository.previewSale();
        } else {
            return saleRepository.storeSerch(keyword);
        }
    }

    //Sale情報の表示
    public List<SuddenSaleview> previewSuddenSale() {
        return suddensaleRepository.previewSuddenSale();
    }

    //Sale情報をジャンル検索
    public List<SuddenSaleview> storeSuddenSaleSerch(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return suddensaleRepository.previewSuddenSale();
        } else {
            return suddensaleRepository.storeSerch(keyword);
        }
    }


}
