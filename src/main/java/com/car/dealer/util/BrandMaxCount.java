package com.car.dealer.util;

import com.car.dealer.entity.Brand;

/**
 * Created by employee on 6/2/15.
 */
public class BrandMaxCount {
    public Brand brand;
    public Long count;

    public BrandMaxCount(Brand brand, Long count) {
        this.brand = brand;
        this.count = count;
    }

    @Override
    public String toString() {
        return brand.toString() +
                " count = " + count;
    }
}
