package com.splot.todoaapp.dto.mapper;

import com.splot.todoaapp.dto.ApiResponseDto;
import com.splot.todoaapp.dto.CryptoPriceResponseDto;
import com.splot.todoaapp.model.CryptoPrice;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class CryptoPriceMapper {
    public CryptoPrice parseApiResponseDto(ApiResponseDto dto) {
        CryptoPrice cryptoPrice = new CryptoPrice();
        cryptoPrice.setCryptoCurrency(dto.getCurr1());
        cryptoPrice.setRegularCurrency(dto.getCurr2());
        cryptoPrice.setPrice(dto.getLprice());
        cryptoPrice.setCreatedAt(LocalDateTime.now());
        return  cryptoPrice;
    }

    public CryptoPriceResponseDto toResponseDto(CryptoPrice cryptoPrice) {
        CryptoPriceResponseDto dto = new CryptoPriceResponseDto();
        dto.setCryptoCurrency(cryptoPrice.getCryptoCurrency());
        dto.setRegularCurrency(cryptoPrice.getRegularCurrency());
        dto.setPrice(cryptoPrice.getPrice());
        dto.setAtTime(cryptoPrice.getCreatedAt());
        return dto;
    }
}
