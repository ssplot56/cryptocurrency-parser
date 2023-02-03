package com.splot.todoaapp.service.impl;

import com.splot.todoaapp.dto.ApiResponseDto;
import com.splot.todoaapp.dto.mapper.CryptoPriceMapper;
import com.splot.todoaapp.model.CryptoPrice;
import com.splot.todoaapp.repository.CryptoPriceRepository;
import com.splot.todoaapp.service.CryptoPriceService;
import com.splot.todoaapp.service.HttpClient;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Scheduled(fixedDelay = 10000)
    @Override
    public void addCurrentCryptoPrices() {
        ApiResponseDto btcDto = httpClient
                .get("https://cex.io/api/last_price/BTC/USD", ApiResponseDto.class);
        ApiResponseDto ethDto = httpClient
                .get("https://cex.io/api/last_price/ETH/USD", ApiResponseDto.class);
        ApiResponseDto xprDto = httpClient
                .get("https://cex.io/api/last_price/XRP/USD", ApiResponseDto.class);
        List<ApiResponseDto> dtosToSave = List.of(btcDto, ethDto, xprDto);
        saveDtosToDB(dtosToSave);
    }

    @Override
    public CryptoPrice getLowestPriceByCryptocurrency(String cryptocurrency) {
        return repository.findFirstByCryptoCurrencyOrderByPriceAsc(cryptocurrency);
    }

    @Override
    public CryptoPrice getHighestPriceByCryptocurrency(String cryptocurrency) {
        return repository.findFirstByCryptoCurrencyOrderByPriceDesc(cryptocurrency);
    }

    @Override
    public List<CryptoPrice> getAllPriceByName(String cryptocurrency, PageRequest pageRequest) {
        return repository.findAllByCryptoCurrency(cryptocurrency, pageRequest);
    }

    private void saveDtosToDB(List<ApiResponseDto> apiResponseDtos) {
        apiResponseDtos.stream()
                .map(mapper::parseApiResponseDto)
                .forEach(repository::save);
    }
}
