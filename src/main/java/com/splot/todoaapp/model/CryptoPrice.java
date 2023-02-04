package com.splot.todoaapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;

@Document
@Data
public class CryptoPrice {
    @Id
    private String id;
    @Field
    private String cryptoCurrency;
    @Field
    private String regularCurrency;
    @Field
    private Double price;
    @Field
    private LocalDateTime createdAt;
}
