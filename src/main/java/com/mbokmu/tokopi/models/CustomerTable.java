package com.mbokmu.tokopi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customer_table")
@Getter
@Setter
public class CustomerTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String table_number;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL)
    List<Htrans> htrans;
}
