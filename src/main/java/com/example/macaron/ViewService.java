package com.example.macaron;

import java.util.List;

public class ViewService {
    private final SuddenSaleRepository suddensaleRepository;
    private final SaleRepository saleRepository;

    public ViewService(SuddenSaleRepository suddensaleRepository, SaleRepository saleRepository) {
        this.suddensaleRepository = suddensaleRepository;
        this.saleRepository = saleRepository;
    }

    public List<Sale> KeySerch(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return SaleRepository.preview();
        } else {
            return SaleRepository.searchByTitle(keyword);
        }
    }


}
