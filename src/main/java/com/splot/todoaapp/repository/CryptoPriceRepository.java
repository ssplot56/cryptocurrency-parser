package com.splot.todoaapp.repository;

import com.splot.todoaapp.model.CryptoPrice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CryptoPriceRepository extends MongoRepository<CryptoPrice, Long> {
    CryptoPrice findFirstByCryptoCurrencyOrderByPriceAsc(String cryptocurrency);

    CryptoPrice findFirstByCryptoCurrencyOrderByPriceDesc(String cryptocurrency);

    List<CryptoPrice> findAllByCryptoCurrency(String cryptocurrency, Pageable pageable);
}
