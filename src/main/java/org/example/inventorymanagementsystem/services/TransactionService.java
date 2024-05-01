package org.example.inventorymanagementsystem.services;

import org.example.inventorymanagementsystem.models.Item;
import org.example.inventorymanagementsystem.models.Transaction;
import org.example.inventorymanagementsystem.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Create
    public Transaction addTransaction(Item item, Transaction.TransactionType type, int quantity) {
        Transaction transaction = new Transaction();
        transaction.setItem(item);
        transaction.setINCOMING(type);
        transaction.setQuantity(quantity);
        transaction.setDate(new Date());
        return transactionRepository.save(transaction);
    }

    // Read
    public Optional<Transaction> getTransactionById(long id) {
        return transactionRepository.findById(id);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getAllTransactionsForItem(Item item) {
        return item.getTransactions();
    }
}
