package com.splot.todoaapp.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CryptoPriceResponseDto {
    private String cryptoCurrency;
    private String regularCurrency;
    private Double price;
    private LocalDateTime atTime;
}
