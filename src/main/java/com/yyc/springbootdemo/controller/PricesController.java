package com.yyc.springbootdemo.controller;

import com.yyc.springbootdemo.dto.PriceDto;
import com.yyc.springbootdemo.model.Prices;
import com.yyc.springbootdemo.service.PricesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * La clase para publicar los WebServices
 * */
@RestController
public class PricesController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PricesServiceImpl pricesService;

    @GetMapping("/priceActive")
    public ResponseEntity<PriceDto> findPriceActive(@RequestParam(value = "productId", required = true) String productId, @RequestParam(value = "brandId", required = true) int brandId, @RequestParam(value = "fechaApplication", required = true) String fechaApplication) {
        logger.debug("Empezar buscar precio");
        PriceDto dto = new PriceDto();

        // Consultar precio en BBDD
        Prices price = pricesService.findPriceByParameters(productId, brandId, fechaApplication);
        // Si no se encuentra
        if(price == null){
            logger.debug("Objeto no encontrado");
            // Configurar mensaje de error
            dto.setMsgError("Tarifa no encontrada.");
            return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        } else {
            // Configurar fecha de aplicacion
            // Si el formato de la fecha no esta "yyyy-MM-dd HH:mm:ss", devuelve error
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                dto.setApplicationDate(sdf.parse(fechaApplication));
            } catch (ParseException e) {
                // Configurar mensaje de error
                dto.setMsgError("Error en formato de la fecha. El formato debería ser 'yyyy-MM-dd HH:mm:ss'");
                return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
            }
            BeanUtils.copyProperties(price, dto);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
