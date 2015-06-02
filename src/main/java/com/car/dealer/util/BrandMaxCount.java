package com.car.dealer.util;

import com.car.dealer.entity.Brand;

/**
 * Created by employee on 6/2/15.
 */
public class BrandMaxCount {
    public Brand brand;
    public Integer count;

    public BrandMaxCount(Brand brand, Integer count) {
        this.brand = brand;
        this.count = count;
    }

    @Override
    public String toString() {
        return brand.toString() +
                " count = " + count;
    }
}
