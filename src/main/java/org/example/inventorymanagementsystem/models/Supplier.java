package org.example.inventorymanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String description;
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Item> items;


    public Supplier() {
        // No-args constructor required by JPA
    }


}
