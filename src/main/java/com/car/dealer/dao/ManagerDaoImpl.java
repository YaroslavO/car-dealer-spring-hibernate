package com.car.dealer.dao;

import com.car.dealer.entity.Manager;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Repository
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveManager(Manager manager) {
        sessionFactory.getCurrentSession().save(manager);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Manager> getAllManager() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Manager.class)
                .list();
    }
}
