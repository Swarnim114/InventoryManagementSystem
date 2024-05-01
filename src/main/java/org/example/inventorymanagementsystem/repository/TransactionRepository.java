package org.example.inventorymanagementsystem.repository;

import org.example.inventorymanagementsystem.models.Item;
import org.example.inventorymanagementsystem.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByItem(Item item);
}
