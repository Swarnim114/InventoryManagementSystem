package org.example.inventorymanagementsystem.services;

import org.example.inventorymanagementsystem.models.Item;
import org.example.inventorymanagementsystem.models.Supplier;
import org.example.inventorymanagementsystem.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    // Create
    public Supplier addSupplier(Supplier supplier) {
        // Save the supplier to the database using the SupplierRepository
        return supplierRepository.save(supplier);
    }

    // Read
    public Optional<Supplier> getSupplierById(long id) {
        return supplierRepository.findById(id);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // Update
    public Optional<Supplier> updateSupplier(long id, Supplier newSupplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier existingSupplier = optionalSupplier.get();
            // Update existing supplier fields
            existingSupplier.setName(newSupplier.getName());
            existingSupplier.setEmail(newSupplier.getEmail());
            existingSupplier.setPhone(newSupplier.getPhone());
            existingSupplier.setDescription(newSupplier.getDescription());
            // Save the updated supplier
            return Optional.of(supplierRepository.save(existingSupplier));
        } else {
            return Optional.empty();
        }
    }

    // Delete
    public boolean deleteSupplier(long id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Item> getItemsBySupplierId(long supplierId) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
        if (optionalSupplier.isPresent()) {
            Supplier supplier = optionalSupplier.get();
            // Get the items associated with the supplier
            return supplier.getItems();
        } else {
            return null; // Supplier not found
        }
    }
}
