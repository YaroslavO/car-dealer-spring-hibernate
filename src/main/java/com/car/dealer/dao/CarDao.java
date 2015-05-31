package com.car.dealer.dao;

import com.car.dealer.entity.Car;

import java.util.List;

/**
 * Created by Yaroslav on 31.05.2015.
 */
public interface CarDao {
    void addCar(Car car);
    List<Car> getAllCar();
}
