package com.mbokmu.tokopi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtransDto {
    private int qty;
    private int price;
    private int subtotal;
    private String status;
    private int htransId;
    private int menuId;

    public DtransDto() {
    }

    public DtransDto(int qty, int price, int subtotal, String status, int htransId, int menuId) {
        this.qty = qty;
        this.price = price;
        this.subtotal = subtotal;
        this.status = status;
        this.htransId = htransId;
        this.menuId = menuId;
    }
}
