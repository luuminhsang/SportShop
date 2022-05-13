package com.project.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "productInfor")
public class ProductInfor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String avatar;
    @Column
    private String img1;
    @Column
    private String img2;
    @Column
    private String img3;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(columnDefinition = "VARCHAR(255) CHARSET utf8")
    private String describe1;
    @Column(columnDefinition = "VARCHAR(255) CHARSET utf8")
    private String describe2;
    @Column(columnDefinition = "VARCHAR(255) CHARSET utf8")
    private String describe3;
    @Column(columnDefinition = "VARCHAR(255) CHARSET utf8")
    private String describe4;
    @Column(columnDefinition = "VARCHAR(255) CHARSET utf8")
    private String describe5;
}
