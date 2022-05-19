package com.project.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME", length = 30,nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "brand")
    private Set<Product> listProduct;

}
