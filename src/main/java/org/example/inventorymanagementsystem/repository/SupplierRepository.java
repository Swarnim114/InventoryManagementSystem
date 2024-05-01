package org.example.inventorymanagementsystem.repository;

import org.example.inventorymanagementsystem.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // You can add custom query methods here if needed
}