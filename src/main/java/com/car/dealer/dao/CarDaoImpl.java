package com.car.dealer.dao;

import com.car.dealer.entity.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Repository
public class CarDaoImpl implements CarDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAllCar() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Car.class)
                .list();
    }
}
