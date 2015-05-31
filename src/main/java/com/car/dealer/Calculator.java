package com.car.dealer;

import com.car.dealer.dao.ClientDao;
import com.car.dealer.dao.DealDao;
import com.car.dealer.dao.ManagerDao;
import com.car.dealer.entity.Deal;
import com.car.dealer.entity.Manager;
import com.car.dealer.entity.ManagerBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Service
@Transactional
public class Calculator {
    private ManagerDao managerDao;
    private DealDao dealDao;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Autowired
    public void setDealDao(DealDao dealDao) {
        this.dealDao = dealDao;
    }

    public void display() {
        List<Manager> allManager = managerDao.getAllManager();

        for (Manager currentManager: allManager) {
            List<Deal> allDealForManager = dealDao.getAllDealForManager(currentManager);
            Set<ManagerBrand> managerBrandSet = getManagerBrandCountMap(currentManager, allDealForManager);

            ManagerBrand bestManagerBrandOfCount = null;
            ManagerBrand bestManagerBrandOfPrice = null;
            int count;
            int maxCount = 0;
            double price;
            double maxPrice = 0;

            for (ManagerBrand mb: managerBrandSet) {
                count = mb.getCount();
                price = mb.getPriceOfDeals();

                if (count > maxCount) {
                    maxCount = count;
                    bestManagerBrandOfCount = mb;
                }

                if (price > maxPrice) {
                    maxPrice = price;
                    bestManagerBrandOfPrice = mb;
                }
            }

            System.out.println(currentManager.toString());
            System.out.println(bestManagerBrandOfCount.toString() + "count = " + maxCount);
            System.out.println(bestManagerBrandOfPrice.toString() + "price = " + maxPrice);
        }
    }

    private Set<ManagerBrand> getManagerBrandCountMap(Manager manager, List<Deal> deals) {
        TreeSet<ManagerBrand> managerBrandSet = new TreeSet<>();
        ManagerBrand managerBrand;
        double price;
        double profit;

        for (Deal deal: deals) {
            managerBrand = new ManagerBrand(manager, deal.getCar().getBrand());
            price = deal.getCar().getPrice();
            if (managerBrandSet.contains(managerBrand)) {
                for (ManagerBrand mb: managerBrandSet) {
                    if (mb.compareTo(managerBrand) == 0) {
                        managerBrand = mb;
                        break;
                    }
                }
                managerBrand.setCount(managerBrand.getCount() + 1);
                profit = managerBrand.getPriceOfDeals();
                profit += price;
                managerBrand.setPriceOfDeals(profit);
                managerBrandSet.add(managerBrand);
            } else {
                managerBrand.setPriceOfDeals(price);
                managerBrandSet.add(managerBrand);
            }
        }

        return managerBrandSet;
    }
}
