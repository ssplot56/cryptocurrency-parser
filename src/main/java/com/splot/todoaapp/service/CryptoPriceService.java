package com.splot.todoaapp.service;

import com.splot.todoaapp.model.CryptoPrice;
import java.util.List;

public interface CryptoPriceService {
    void addCurrentCryptoPrices();

    CryptoPrice getLastBtcPrice();

    CryptoPrice getLastEthPrice();

    CryptoPrice getLastXprPrice();

    List<CryptoPrice> getAllPriceByName(String curr);
}
