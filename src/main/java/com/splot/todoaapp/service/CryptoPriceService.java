package com.splot.todoaapp.service;

import com.splot.todoaapp.model.CryptoPrice;
import org.springframework.data.domain.PageRequest;
import java.util.List;

public interface CryptoPriceService {
    void addCurrentCryptoPrices();

    CryptoPrice getLowestPriceByCryptocurrency(String cryptocurrency);

    CryptoPrice getHighestPriceByCryptocurrency(String cryptocurrency);

    List<CryptoPrice> getAllPriceByName(String cryptocurrency, PageRequest pageRequest);
}
