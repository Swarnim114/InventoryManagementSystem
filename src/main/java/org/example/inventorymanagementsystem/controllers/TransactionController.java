package org.example.inventorymanagementsystem.controllers;

import org.example.inventorymanagementsystem.models.Item;
import org.example.inventorymanagementsystem.models.Transaction;
import org.example.inventorymanagementsystem.services.ItemService;
import org.example.inventorymanagementsystem.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final ItemService itemService;

    public TransactionController(TransactionService transactionService, ItemService itemService) {
        this.transactionService = transactionService;
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Item item) {
        Transaction.TransactionType type = Transaction.TransactionType.INCOMING; // Example type
        int quantity = 1; // Example quantity
        Transaction newTransaction = transactionService.addTransaction(item, type, quantity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransaction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") long id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<List<Transaction>> getAllTransactionsForItem(@PathVariable("itemId") long itemId) {
        Item item = itemService.getItemById(itemId).orElse(null);
        if (item != null) {
            List<Transaction> transactions = transactionService.getAllTransactionsForItem(item);
            return ResponseEntity.ok(transactions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
