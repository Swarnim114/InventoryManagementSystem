package org.example.inventorymanagementsystem.services;

import org.example.inventorymanagementsystem.exceptions.InvalidSupplierItemsException;
import org.example.inventorymanagementsystem.exceptions.InvalidSupplierUpdateException;
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

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Optional<Supplier> getSupplierById(long id) {
        return supplierRepository.findById(id);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> updateSupplier(long id, Supplier newSupplier) throws InvalidSupplierUpdateException{
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier existingSupplier = optionalSupplier.get();
            existingSupplier.setName(newSupplier.getName());
            existingSupplier.setEmail(newSupplier.getEmail());
            existingSupplier.setPhone(newSupplier.getPhone());
            existingSupplier.setDescription(newSupplier.getDescription());
            return Optional.of(supplierRepository.save(existingSupplier));
        } else {
            throw new InvalidSupplierUpdateException("Supplier with id " + id + " not found");
        }
    }

    public boolean deleteSupplier(long id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Item> getItemsBySupplierId(long supplierId) throws InvalidSupplierItemsException {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
        if (optionalSupplier.isPresent()) {
            Supplier supplier = optionalSupplier.get();
            return supplier.getItems();
        } else {
            throw new InvalidSupplierItemsException("Supplier with id " + supplierId + " not found");
        }
    }
}
