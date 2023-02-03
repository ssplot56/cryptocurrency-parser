package com.splot.todoaapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;

@Document
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public String getRegularCurrency() {
        return regularCurrency;
    }

    public void setRegularCurrency(String regularCurrency) {
        this.regularCurrency = regularCurrency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CryptoPrice{" +
                "id='" + id + '\'' +
                ", curr1='" + cryptoCurrency + '\'' +
                ", curr2='" + regularCurrency + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
