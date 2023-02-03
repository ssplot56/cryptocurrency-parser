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
        cryptoPrice.setCurr1(dto.getCurr1());
        cryptoPrice.setCurr2(dto.getCurr2());
        cryptoPrice.setPrice(dto.getLastPrice());
        cryptoPrice.setCreatedAt(LocalDateTime.now());
        return  cryptoPrice;
    }

    public CryptoPriceResponseDto toResponseDto(CryptoPrice cryptoPrice) {
        CryptoPriceResponseDto dto = new CryptoPriceResponseDto();
        dto.setCurr1(cryptoPrice.getCurr1());
        dto.setCurr2(cryptoPrice.getCurr2());
        dto.setPrice(cryptoPrice.getPrice());
        return dto;
    }
}
