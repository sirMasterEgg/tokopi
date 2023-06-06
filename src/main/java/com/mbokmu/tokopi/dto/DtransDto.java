package com.mbokmu.tokopi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtransDto {
    private int qty;
    private int price;
    private String status;
    private int htrans_id;
    private int menu_id;

    public DtransDto() {
    }

    public DtransDto(int qty, int price, String status, int htrans_id, int menu_id) {
        this.qty = qty;
        this.price = price;
        this.status = status;
        this.htrans_id = htrans_id;
        this.menu_id = menu_id;
    }
}
