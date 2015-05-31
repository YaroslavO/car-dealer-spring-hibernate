package com.car.dealer.entity;

/**
 * Created by Yaroslav on 31.05.2015.
 */
public class BestManagerBrand {
    public int count = 0;
    public double price = 0;
    public ManagerBrand BestCountManagerBrand;
    public ManagerBrand BestPriceManagerBrand;

    public BestManagerBrand(ManagerBrand bestCountManagerBrand, ManagerBrand bestPriceManagerBrand) {
        BestCountManagerBrand = bestCountManagerBrand;
        BestPriceManagerBrand = bestPriceManagerBrand;
    }

    public BestManagerBrand() {
    }
}
