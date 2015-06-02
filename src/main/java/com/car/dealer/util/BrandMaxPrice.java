package com.car.dealer.util;

import com.car.dealer.entity.Brand;

/**
 * Created by employee on 6/2/15.
 */
public class BrandMaxPrice {
    public Brand brand;
    public Double price;

    public BrandMaxPrice(Brand brand, Double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return brand.toString() +
                " price = " + price;
    }
}
