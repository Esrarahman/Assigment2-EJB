package com.ejb.assigment.services;

import com.ejb.assigment.model.Inventory;

import java.util.List;

public interface InventoryEJB {

    void addInventory(Inventory inventory2);
    List<Inventory> getAll();
    boolean deleteInventory(Long id);
}
