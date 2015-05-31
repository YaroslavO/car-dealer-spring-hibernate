package com.car.dealer.entity;

import javax.persistence.*;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Entity
public class Deal {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(name = "fk_car")
    private Car car;

    @OneToOne
    @JoinColumn(name = "fk_manager")
    private Manager manager;

    @OneToOne
    @JoinColumn(name = "fk_client")
    private Client client;

    public Deal() {
    }

    public Deal(Car car, Manager manager, Client client) {
        this.car = car;
        this.manager = manager;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
