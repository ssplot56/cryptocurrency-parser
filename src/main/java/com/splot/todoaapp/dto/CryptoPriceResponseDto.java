package com.splot.todoaapp.dto;

import lombok.Data;

@Data
public class CryptoPriceResponseDto {
    private String curr1;
    private String curr2;
    private Double price;
}
