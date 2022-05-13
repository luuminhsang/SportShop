package com.project.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;
@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column(columnDefinition = "VARCHAR(50) CHARSET utf8")
    private String fullName;
    @Temporal(TemporalType.DATE)
    @Column
    private Calendar dayOfBirth;
    @Column
    private String email;
    @Column
    private String numberPhone;
    @Column(columnDefinition = "VARCHAR(10) CHARSET utf8")
    private String gender;
    @Column
    private String address;
    @OneToMany(mappedBy = "account")
    private Set<Orders> listOrder;
    @Column
    private int role;

}
