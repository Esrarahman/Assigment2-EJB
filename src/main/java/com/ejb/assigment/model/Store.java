package com.ejb.assigment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stores")
@NamedQueries(
        {
                @NamedQuery(name = "Store.findAll",query = "SELECT s FROM Store s")
        }
)
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id",columnDefinition = "smallint")
    private int id;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "location",length = 150)
    private String location;

    @OneToMany(mappedBy = "store",fetch = FetchType.EAGER)
    private List<Inventory> inventories  = new ArrayList<>();
}
