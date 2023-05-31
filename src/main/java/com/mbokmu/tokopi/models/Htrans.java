package com.mbokmu.tokopi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "htrans")
@Getter
@Setter
public class Htrans extends BaseEntity {
    int total_item;
    int total_price;
    String status;

    @OneToMany(mappedBy = "htrans")
    List<Dtrans> dtrans;
}
