package com.splot.todoaapp.service.impl;

import com.splot.todoaapp.dto.ApiResponseDto;
import com.splot.todoaapp.dto.mapper.CryptoPriceMapper;
import com.splot.todoaapp.model.CryptoPrice;
import com.splot.todoaapp.repository.CryptoPriceRepository;
import com.splot.todoaapp.service.CryptoPriceService;
import com.splot.todoaapp.service.HttpClient;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CryptoPriceServiceImpl implements CryptoPriceService {
    private final HttpClient httpClient;
    private final CryptoPriceRepository repository;
    private final CryptoPriceMapper mapper;

    public CryptoPriceServiceImpl(HttpClient httpClient,
                                  CryptoPriceRepository repository,
                                  CryptoPriceMapper mapper) {
        this.httpClient = httpClient;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void addCurrentCryptoPrices() {
        ApiResponseDto btcDto = httpClient
                .get("https://cex.io/api/last_price/BTC/USD", ApiResponseDto.class);
        ApiResponseDto ethDto = httpClient
                .get("https://cex.io/api/last_price/ETH/USD", ApiResponseDto.class);
        ApiResponseDto xprDto = httpClient
                .get("https://cex.io/api/last_price/XPR/USD", ApiResponseDto.class);
        List<ApiResponseDto> dtosToSave = List.of(btcDto, ethDto, xprDto);
        saveDtosToDB(dtosToSave);
    }

    @Override
    public CryptoPrice getLastBtcPrice() {
        return null;
    }

    @Override
    public CryptoPrice getLastEthPrice() {
        return null;
    }

    @Override
    public CryptoPrice getLastXprPrice() {
        return null;
    }

    @Override
    public List<CryptoPrice> getAllPriceByName(String curr) {
        return null;
    }

    private void saveDtosToDB(List<ApiResponseDto> apiResponseDtos) {
        apiResponseDtos.stream()
                .map(mapper::parseApiResponseDto)
                .forEach(repository::save);
    }
}
