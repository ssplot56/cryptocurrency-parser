package com.splot.todoaapp.controller;

import com.splot.todoaapp.dto.CryptoPriceResponseDto;
import com.splot.todoaapp.dto.mapper.CryptoPriceMapper;
import com.splot.todoaapp.service.CryptoPriceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cryptocurrencies")
public class CryptocurrencyController {
    private final CryptoPriceService service;
    private final CryptoPriceMapper mapper;

    public CryptocurrencyController(CryptoPriceService service, CryptoPriceMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/minprice")
    public CryptoPriceResponseDto getMinCryptocurrencyByName(@RequestParam(value = "name") String name) {
        return mapper.toResponseDto(service.getLowestPriceByCryptocurrency(name.toUpperCase()));
    }

    @GetMapping("/maxprice")
    public CryptoPriceResponseDto getMaxCryptocurrencyByName(@RequestParam(value = "name") String name) {
        return mapper.toResponseDto(service.getHighestPriceByCryptocurrency(name.toUpperCase()));
    }

}
