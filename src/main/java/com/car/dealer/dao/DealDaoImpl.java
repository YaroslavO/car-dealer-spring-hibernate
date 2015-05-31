package com.car.dealer.dao;

import com.car.dealer.entity.Deal;
import com.car.dealer.entity.Manager;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Repository
public class DealDaoImpl implements DealDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addDeal(Deal deal) {
        sessionFactory.getCurrentSession().save(deal);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Deal> getAllDeal() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Deal.class)
                .list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Deal> getAllDealForManager(Manager manager) {
        return sessionFactory.getCurrentSession()
                .createCriteria(Deal.class)
                .add(Restrictions.eq("manager", manager))
                .list();
    }

}
