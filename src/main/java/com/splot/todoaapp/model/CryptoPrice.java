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
    private String firstCryptocurrency;
    @Field
    private String secondCryptocurrency;
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

    public String getFirstCryptocurrency() {
        return firstCryptocurrency;
    }

    public void setFirstCryptocurrency(String firstCryptocurrency) {
        this.firstCryptocurrency = firstCryptocurrency;
    }

    public String getSecondCryptocurrency() {
        return secondCryptocurrency;
    }

    public void setSecondCryptocurrency(String secondCryptocurrency) {
        this.secondCryptocurrency = secondCryptocurrency;
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
                ", curr1='" + firstCryptocurrency + '\'' +
                ", curr2='" + secondCryptocurrency + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
