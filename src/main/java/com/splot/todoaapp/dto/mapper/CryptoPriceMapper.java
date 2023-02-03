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
        cryptoPrice.setFirstCryptocurrency(dto.getCurr1());
        cryptoPrice.setSecondCryptocurrency(dto.getCurr2());
        cryptoPrice.setPrice(dto.getLprice());
        cryptoPrice.setCreatedAt(LocalDateTime.now());
        return  cryptoPrice;
    }

    public CryptoPriceResponseDto toResponseDto(CryptoPrice cryptoPrice) {
        CryptoPriceResponseDto dto = new CryptoPriceResponseDto();
        dto.setCurr1(cryptoPrice.getFirstCryptocurrency());
        dto.setCurr2(cryptoPrice.getSecondCryptocurrency());
        dto.setPrice(cryptoPrice.getPrice());
        return dto;
    }
}
