package com.splot.todoaapp.repository;

import com.splot.todoaapp.model.CryptoPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoPriceRepository extends MongoRepository<CryptoPrice, Long> {
    CryptoPrice findFirstByFirstCryptocurrencyOrderByPriceAsc(String curr1);

    CryptoPrice findFirstByFirstCryptocurrencyOrderByPriceDesc(String curr1);
}
