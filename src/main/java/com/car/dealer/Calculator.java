package com.car.dealer;

import com.car.dealer.dao.DealDao;
import com.car.dealer.dao.ManagerDao;
import com.car.dealer.entity.BestManagerBrand;
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
            displayBastBrandForManager(currentManager, allDealForManager);
        }
    }

    private void displayBastBrandForManager(Manager currentManager, List<Deal> allDealForManager) {
        Set<ManagerBrand> managerBrandSet = getManagerBrandCountMap(currentManager, allDealForManager);

        BestManagerBrand bestManagerBrand = searchBestBrandForManager(managerBrandSet);

        System.out.println(currentManager.toString());
        System.out.println(bestManagerBrand.BestCountManagerBrand.toString() + " count = " + bestManagerBrand.count);
        System.out.println(bestManagerBrand.BestPriceManagerBrand.toString() + " price = " + bestManagerBrand.price);
    }

    private BestManagerBrand searchBestBrandForManager(Set<ManagerBrand> managerBrandSet) {
        BestManagerBrand bestManagerBrand = new BestManagerBrand();
        int count;
        double price;

        for (ManagerBrand mb: managerBrandSet) {
            count = mb.getCount();
            price = mb.getPriceOfDeals();

            if (count > bestManagerBrand.count) {
                bestManagerBrand.count = count;
                bestManagerBrand.BestCountManagerBrand = mb;
            }

            if (price > bestManagerBrand.price) {
                bestManagerBrand.price = price;
                bestManagerBrand.BestPriceManagerBrand = mb;
            }
        }

        return bestManagerBrand;
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
                managerBrand = getCurrentManagerBrand(managerBrandSet, managerBrand);
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

    private ManagerBrand getCurrentManagerBrand(TreeSet<ManagerBrand> managerBrandSet, ManagerBrand managerBrand) {
        for (ManagerBrand mb: managerBrandSet) {
            if (mb.compareTo(managerBrand) == 0) {
                managerBrand = mb;
                break;
            }
        }
        return managerBrand;
    }
}
