package com.car.dealer.dao;

import com.car.dealer.entity.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Client> getAllClient() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Client.class)
                .list();
    }

    @Override
    public void addClient(Client client) {
        sessionFactory.getCurrentSession().save(client);
    }
}
