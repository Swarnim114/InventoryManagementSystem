package org.example.inventorymanagementsystem.controllers;

import org.example.inventorymanagementsystem.models.Item;
import org.example.inventorymanagementsystem.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        ResponseEntity<Item> responseEntity = itemService.addItem(item);
        return responseEntity;
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable long id) {
        Optional<Item> optionalItem = itemService.getItemById(id);
        if (optionalItem.isPresent()) {
            return new ResponseEntity<>(optionalItem.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable long id, @RequestBody Item newItem) {
        Optional<Item> optionalUpdatedItem = itemService.updateItem(id, newItem);
        if (optionalUpdatedItem.isPresent()) {
            return new ResponseEntity<>(optionalUpdatedItem.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable long id) {
        boolean deleted = itemService.deleteItem(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
