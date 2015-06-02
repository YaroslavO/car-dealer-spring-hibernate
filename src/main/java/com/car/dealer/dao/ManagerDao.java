package com.car.dealer.dao;

import com.car.dealer.entity.Manager;
import com.car.dealer.util.BrandMaxCount;
import com.car.dealer.util.BrandMaxPrice;

import java.util.List;

/**
 * Created by Yaroslav on 31.05.2015.
 */

public interface ManagerDao {
    void saveManager(Manager manager);
    List<Manager> getAllManager();
    BrandMaxCount getBestBrandOfMaxCount(Manager manager);
    BrandMaxPrice getBestBrandOfMaxSumPrice(Manager manager);
}
