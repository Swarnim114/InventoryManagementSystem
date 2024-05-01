package org.example.inventorymanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Transaction {
    public enum TransactionType {
        INCOMING, OUTGOING
    }

    public enum TransactionStatus {
        PENDING, COMPLETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Item item;

    private TransactionType INCOMING;
    private TransactionStatus PENDING;
    private int Quantity;
    private Date date;
}
