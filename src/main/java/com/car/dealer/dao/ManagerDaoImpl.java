package com.car.dealer.dao;

import com.car.dealer.entity.Brand;
import com.car.dealer.entity.Manager;
import com.car.dealer.util.BrandMaxCount;
import com.car.dealer.util.BrandMaxPrice;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    @Override
    public BrandMaxCount getBestBrandOfMaxCount(Manager manager) {
        String SQL_QUERY = "SELECT d.car.brand, COUNT(d) as deals " +
                "FROM Deal d " +
                "where d.manager = :manager " +
                "GROUP BY d.car.brand " +
                "ORDER BY deals desc";
        Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY).setMaxResults(1);
        query.setParameter("manager", manager);

        Brand brand = (Brand) ((Object[])query.uniqueResult())[0];
        Long count = (Long) ((Object[])query.uniqueResult())[1];

        return new BrandMaxCount(brand, count);
    }

    @Override
    public BrandMaxPrice getBestBrandOfMaxSumPrice(Manager manager) {
        String SQL_QUERY = "SELECT d.car.brand, SUM(d.car.price) as sum_price " +
                "FROM Deal d " +
                "where d.manager = :manager " +
                "GROUP BY d.car.brand " +
                "ORDER BY sum_price desc";
        Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY).setMaxResults(1);
        query.setParameter("manager", manager);

        Brand brand = (Brand) ((Object[])query.uniqueResult())[0];
        Double price = (Double) ((Object[])query.uniqueResult())[1];

        return new BrandMaxPrice(brand, price);
    }
}
