package com.mbokmu.tokopi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dtrans")
@Getter
@Setter
public class Dtrans extends BaseEntity {
    int qty;
    int price;
    int subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    Htrans htrans;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    Menu menu;
}
