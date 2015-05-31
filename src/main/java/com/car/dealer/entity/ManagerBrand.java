package com.car.dealer.entity;

/**
 * Created by Yaroslav on 31.05.2015.
 */
public class ManagerBrand implements Comparable{
    private Manager manager;
    private Brand brand;
    private int count = 1;
    private double priceOfDeals;

    public ManagerBrand (Manager manager, Brand brand) {
        this.manager = manager;
        this.brand = brand;
    }

    @Override
    public int compareTo(Object o) {
        ManagerBrand managerBrand = ((ManagerBrand) o);
        int result = 0;

        result += manager.compareTo(managerBrand.getManager()) == 0 ? 0 : 1;
        result += brand == managerBrand.getBrand() ? 0 : 1;

        return result;
    }

    public Manager getManager() {
        return manager;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPriceOfDeals() {
        return priceOfDeals;
    }

    public void setPriceOfDeals(double priceOfDeal) {
        this.priceOfDeals = priceOfDeal;
    }

    @Override
    public String toString() {
        return brand.getName();
    }
}
