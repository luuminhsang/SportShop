package com.project.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;
@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Temporal(TemporalType.DATE)
    @Column
    private Calendar orderDate;
    @Column
    private long totalMoney;
    @Column(columnDefinition = "VARCHAR(255) CHARSET utf8")
    private String deliveryAddress;
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> listOrderDetail;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Temporal(TemporalType.DATE)
    @Column
    private Calendar deliveryDate;

}
