package com.car.dealer.dao;

import com.car.dealer.entity.Client;

import java.util.List;

/**
 * Created by Yaroslav on 31.05.2015.
 */
public interface ClientDao {
    void addClient(Client client);
    List<Client> getAllClient();
}
