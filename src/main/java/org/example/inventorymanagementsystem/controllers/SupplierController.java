package org.example.inventorymanagementsystem.controllers;

import org.example.inventorymanagementsystem.models.Item;
import org.example.inventorymanagementsystem.models.Supplier;
import org.example.inventorymanagementsystem.services.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier newSupplier = supplierService.addSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSupplier);
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok().body(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable long id) {
        Optional<Supplier> optionalSupplier = supplierService.getSupplierById(id);
        if (optionalSupplier.isPresent()) {
            return ResponseEntity.ok().body(optionalSupplier.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable long id, @RequestBody Supplier newSupplier) {
        Optional<Supplier> updatedSupplier = supplierService.updateSupplier(id, newSupplier);
        if (updatedSupplier.isPresent()) {
            return ResponseEntity.ok().body(updatedSupplier.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable long id) {
        boolean deleted = supplierService.deleteSupplier(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{supplierId}/items")
    public ResponseEntity<List<Item>> getItemsBySupplierId(@PathVariable long supplierId) {
        List<Item> items = supplierService.getItemsBySupplierId(supplierId);
        if (items != null) {
            return ResponseEntity.ok().body(items);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
