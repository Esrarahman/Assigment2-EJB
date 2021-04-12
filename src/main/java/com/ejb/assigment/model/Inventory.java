package com.ejb.assigment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventories")
@NamedQueries(
        {
               @NamedQuery(name = "Inventory.findAll",query = "SELECT i FROM Inventory i")
        }
)
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id",columnDefinition = "smallint")
    private Long id;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "sport",length = 50)
    private String sport;

    @Column(name = "quantity",columnDefinition = "smallint")
    private int quantity;

    @Column(name = "pricePerUnit",columnDefinition = "NUMERIC(5,2)")
    private double pricePerUnit;

    @Column(name = "updated", columnDefinition = "TIMESTAMP")
    private LocalDateTime updated;

    @Column(name = "created", columnDefinition = "TIMESTAMP")
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "store_id_fk")
    private Store store;
}
