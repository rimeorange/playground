package com.multi.member.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "barcode")
    private String name;

    @Column(name = "productName")
    private String birthday;


}
