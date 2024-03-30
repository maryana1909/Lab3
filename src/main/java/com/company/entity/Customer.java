package com.company.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@NamedQuery(name = "Customer.getAll", query = "SELECT u from Customer u")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "city", nullable = false, length = 45)
    private String city;
}