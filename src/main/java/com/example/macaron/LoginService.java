package com.example.macaron;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final StoreRepositry storeRepositry;
    private final SaleRepositry saleRepositry;
    private final UserRepositry userRepositry;


    public LoginService(StoreRepositry storeRepositry,SaleRepositry saleRepositry,UserRepositry userRepositry){
        this.storeRepositry = storeRepositry;
        this.saleRepositry = saleRepositry;
        this.userRepositry = userRepositry;
    }

}