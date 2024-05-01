package org.example.inventorymanagementsystem.services;

import org.example.inventorymanagementsystem.models.Item;
import org.example.inventorymanagementsystem.repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Create
    public ResponseEntity<Item> addItem(Item item) {
        // Save the item to the database using the ItemRepository
        Item savedItem = itemRepository.save(item);

        // Return a ResponseEntity with the saved item and a success status
        return ResponseEntity.ok(savedItem);
    }


    // Read
    public Optional<Item> getItemById(long id) {
        return itemRepository.findById(id);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Update
    // Update
    public Optional<Item> updateItem(long id, Item newItem) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item existingItem = optionalItem.get();
            // Update everything except the supplier
            existingItem.setName(newItem.getName());
            existingItem.setQuantity(newItem.getQuantity());
            existingItem.setPrice(newItem.getPrice());
            // Save the updated item
            return Optional.of(itemRepository.save(existingItem));
        } else {
            return Optional.empty();
        }
    }

    // Delete
    public boolean deleteItem(long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}