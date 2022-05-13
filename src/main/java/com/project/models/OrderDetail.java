package com.project.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "oderDetail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    @Column
    private int quantity;
    @Column
    private long subtotal;
}
