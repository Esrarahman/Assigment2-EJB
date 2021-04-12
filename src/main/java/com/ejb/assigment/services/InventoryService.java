package com.ejb.assigment.services;

import com.ejb.assigment.model.Inventory;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Singleton
@Remote(InventoryEJB.class)
public class InventoryService implements InventoryEJB {

    protected EntityManager entityManager = Persistence.createEntityManagerFactory("ejbPU").createEntityManager();

    @Override
    public void addInventory(Inventory inventory) {
        entityManager.persist(inventory);
    }

    @Override
    public List<Inventory> getAll() {
        Query query = entityManager.createNamedQuery("Inventory.findAll", Inventory.class);
        List<Inventory> inventories = query.getResultList();
        return inventories;
    }

    @Override
    public boolean deleteInventory(Long id) {
        Inventory inventory = entityManager.find(Inventory.class, id);
        if (inventory != null) {
            entityManager.remove(inventory);
            return true;
        } else {
            return false;
        }
    }
}
