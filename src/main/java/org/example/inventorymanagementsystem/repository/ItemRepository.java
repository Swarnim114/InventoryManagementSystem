package org.example.inventorymanagementsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.inventorymanagementsystem.models.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Additional custom queries can be defined here if needed
}