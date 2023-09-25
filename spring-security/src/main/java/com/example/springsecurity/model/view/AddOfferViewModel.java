package com.example.springsecurity.model.view;

import com.example.springsecurity.model.validation.YearInPastOrPresent;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

public class AddOfferViewModel {
    private Long id;
    @NotEmpty
    private String model;
    @NotNull
    @DecimalMin("100")
    private BigDecimal price;
    @NotEmpty
    private String engine;
    @NotEmpty
    private String transmission;
    @YearInPastOrPresent(minYear = 1930)
    private Integer year;
    @NotNull @PositiveOrZero
    private Integer mileage;
    @NotEmpty @Size(min = 10, max = 3000)
    private String description;
    @NotEmpty
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public AddOfferViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public AddOfferViewModel setModel(String model) {
        this.model = model;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddOfferViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public AddOfferViewModel setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public AddOfferViewModel setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferViewModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public AddOfferViewModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddOfferViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
