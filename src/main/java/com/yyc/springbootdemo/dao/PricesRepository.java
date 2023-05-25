package com.yyc.springbootdemo.dao;

import com.yyc.springbootdemo.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PricesRepository extends JpaRepository<Prices, Integer> {

    /**
     * Montar query personalizada para consultar la tarifa correspodiente según los parametros
     * */
    @Query(value ="SELECT price_list as priceList, brand_id as brandId, start_date as startDate, end_date as endDate, product_id as productId, priority, price, curr" +
            " FROM prices p WHERE   start_date <=  :fechaApplication and  :fechaApplication <=  end_date AND brand_id = :brandId AND product_id = :productId ORDER BY priority DESC limit 1", nativeQuery = true)
    Prices findByParameters(@Param("productId") String productId, @Param("brandId") int brandId, @Param("fechaApplication") String fechaApplication);
}
