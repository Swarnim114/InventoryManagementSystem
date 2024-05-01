package org.example.inventorymanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name;
    private int quantity;
    private double price;
    @ManyToOne
    private Supplier supplier;

    public Item(Long id, String name, int quantity, double price, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;

    }
    public Item() {
        // No-args constructor required by JPA
    }


}
