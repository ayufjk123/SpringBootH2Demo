package com.yyc.springbootdemo.service;

import com.yyc.springbootdemo.dao.PricesRepository;
import com.yyc.springbootdemo.model.Prices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase servicio para consultar a BBDD
 * */
@Service
public class PricesServiceImpl implements PricesService{
    @Autowired
    private PricesRepository pricesRepository;

    @Override
    public Prices findPriceByParameters(String productId, int brandId, String fechaApplication) {
        return pricesRepository.findByParameters(productId, brandId, fechaApplication);
    }
}
