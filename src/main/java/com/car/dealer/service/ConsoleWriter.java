package com.car.dealer.service;

import com.car.dealer.dao.ManagerDao;
import com.car.dealer.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Service
@Transactional
public class ConsoleWriter {
    private ManagerDao managerDao;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    public void write() {
        List<Manager> allManager = managerDao.getAllManager();

        for (Manager currentManager: allManager) {
            System.out.println(currentManager.toString());
            System.out.println(managerDao.getBestBrandOfMaxCount(currentManager).toString());
            System.out.println(managerDao.getBestBrandOfMaxSumPrice(currentManager).toString());
        }
    }
}
