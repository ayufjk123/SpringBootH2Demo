package com.yyc.springbootdemo.service;


import com.yyc.springbootdemo.model.Prices;

public interface PricesService {
    /**
     * Buscar los datos de precio según el ID de la marca e id del producto
     * @param productId id de producto
     * @param brandId id de la cadena del grupo
     * @param fechaApplication fecha de la application
     */
    Prices findPriceByParameters(String productId, int brandId, String fechaApplication);
}
