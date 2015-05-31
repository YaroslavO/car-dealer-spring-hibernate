package com.car.dealer.entity;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Integer id;
    private String model;
    private Double price;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    public Car() {
    }

    public Car(Brand brand, String model, Double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
