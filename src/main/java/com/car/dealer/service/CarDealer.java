package com.car.dealer.service;

import com.car.dealer.dao.CarDao;
import com.car.dealer.dao.ClientDao;
import com.car.dealer.dao.DealDao;
import com.car.dealer.dao.ManagerDao;
import com.car.dealer.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Service
@Transactional
public class CarDealer {

    private CarDao carDao;
    private ClientDao clientDao;
    private ManagerDao managerDao;
    private DealDao dealDao;

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Autowired
    public void setDealDao(DealDao dealDao) {
        this.dealDao = dealDao;
    }

    private List<Car> cars = new ArrayList<>();;
    private List<Client> clients = new ArrayList<>();
    private List<Manager> managers = new ArrayList<>();

    public void init() {

        initCar();

        initManager();

        initClient();

        initDeal();
    }

    private void initDeal() {
        Deal deal;

        cars = carDao.getAllCar();
        clients = clientDao.getAllClient();
        managers = managerDao.getAllManager();

        for (int i=1; i <= 20; i++) {
            deal = new Deal(cars.get(getRandomIndexFromList(cars)),
                    managers.get(getRandomIndexFromList(managers)),
                    clients.get((getRandomIndexFromList(clients))));
            dealDao.addDeal(deal);
        }
    }

    private void initManager() {
        Manager manager = new Manager("Dmitro", "Antonov", 200.0);
        managerDao.saveManager(manager);

        manager = new Manager("Stepan", "Fedoreds", 150.0);
        managerDao.saveManager(manager);

        manager = new Manager("Volodimir", "Clichko", 200.0);
        managerDao.saveManager(manager);
    }

    private void initClient() {
        saveClientInDataBase("Petro", "Smagluk");
        saveClientInDataBase("Stepan", "Vernugora");
        saveClientInDataBase("Roman", "Kulikov");
    }

    private void saveClientInDataBase(String firstName, String lastName) {
        Client client = new Client(firstName, lastName);
        clientDao.addClient(client);
    }

    private void initCar() {
        saveCarInDataBase("BMW", "X6", 20000.0);
        saveCarInDataBase("Tesla", "S", 40000.0);
        saveCarInDataBase("Audi", "A6", 25000.0);
        saveCarInDataBase("Audi", "A8", 30000.0);
        saveCarInDataBase("Renault", "Logan", 40000.0);
    }

    private void saveCarInDataBase(String nameBrand, String model, double price) {
        Car car = new Car(Brand.getBrandByName(nameBrand), model, price);
        carDao.addCar(car);
    }

    public Integer getRandomIndexFromList(List list) {
        return new Random().nextInt(list.size());
    }
}
