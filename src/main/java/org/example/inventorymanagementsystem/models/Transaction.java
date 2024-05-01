package org.example.inventorymanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long id;
    private Item item;
    private Long itemid;
    private TransactionType ONLINE;
    private TransactionStatus PENDING;
    private int Quantity;
    private Date date;
}


