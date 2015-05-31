package com.car.dealer.dao;

import com.car.dealer.entity.Deal;
import com.car.dealer.entity.Manager;

import java.util.List;

/**
 * Created by Yaroslav on 31.05.2015.
 */
public interface DealDao {
    void addDeal(Deal deal);
    List<Deal> getAllDeal();
    List<Deal> getAllDealForManager(Manager manager);
}
