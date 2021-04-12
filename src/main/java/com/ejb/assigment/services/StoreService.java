package com.ejb.assigment.services;


import com.ejb.assigment.model.Store;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.*;
import java.util.List;

@Singleton
@Remote(StoreEJB.class)
public class StoreService implements StoreEJB{

    @PersistenceContext(unitName = "ejbPU")
    protected EntityManager entityManager ;
            //= Persistence.createEntityManagerFactory("ejbPU").createEntityManager();

    @Override
    public void addStore(Store store) {
        entityManager.persist(store);
    }

    @Override
    public List<Store> getAll() {
        Query query = entityManager.createNamedQuery("Store.findAll", Store.class);
        List<Store> stores = query.getResultList();
        return stores;
    }

    @Override
    public Store findStoreById(int id) {

        Store store = entityManager.find(Store.class,id);

        return store;
    }
}
