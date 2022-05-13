package com.project.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @OneToOne(mappedBy = "product")
    private ProductInfor productInfor;
    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> listOrderDetail;
    @Column(columnDefinition = "VARCHAR(100) CHARSET utf8")
    private String name;
    @Column
    private int price;
    @Column
    private int promotionPrice;
    @Column
    private int sold;
    @Column
    private int inStock;
    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
