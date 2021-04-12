package com.ejb.assigment.services;

import com.ejb.assigment.model.Store;

import java.util.List;

public interface StoreEJB {
    void addStore(Store store);
    Store findStoreById(int id);
    List<Store > getAll();
}
