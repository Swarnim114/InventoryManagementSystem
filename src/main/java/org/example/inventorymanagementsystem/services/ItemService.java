package org.example.inventorymanagementsystem.services;

import org.example.inventorymanagementsystem.exceptions.InvalidItemUpdateException;
import org.example.inventorymanagementsystem.exceptions.ItemNotFoundException;
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

    public ResponseEntity<Item> addItem(Item item) {
        Item savedItem = itemRepository.save(item);
        return ResponseEntity.ok(savedItem);
    }

    public Optional<Item> getItemById(long id) throws ItemNotFoundException{
        Optional<Item> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()) {
            return Optional.of(optionalItem.get());
        }else{
            throw new ItemNotFoundException("Item with id " + id + " not found");
        }
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> updateItem(long id, Item newItem) throws InvalidItemUpdateException {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item existingItem = optionalItem.get();
            existingItem.setName(newItem.getName());
            existingItem.setQuantity(newItem.getQuantity());
            existingItem.setPrice(newItem.getPrice());
            return Optional.of(itemRepository.save(existingItem));
        } else {
            throw new InvalidItemUpdateException("Item with id " + id + " not found");
        }
    }

    public boolean deleteItem(long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
