package org.example.inventorymanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private int quantity;
    private double price;
    @ManyToOne
//    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @OneToMany
    private List<Transaction> transactions;

    public Item(Long id, String name, int quantity, double price, Supplier supplier,Transaction transaction) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
        this.transactions.add(transaction);

    }
    public Item() {
        // No-args constructor required by JPA
    }


}
