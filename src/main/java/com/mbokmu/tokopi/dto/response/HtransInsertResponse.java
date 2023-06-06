package com.mbokmu.tokopi.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class HtransInsertResponse {
    private int id;
    private String table_number;
    private String status;
    private int total_price;
    private int total_item;
    private Date created_at;
    private Date updated_at;

    public HtransInsertResponse(int id, String table_number, String status, int total_price, int total_item, Date created_at, Date updated_at) {
        this.id = id;
        this.table_number = table_number;
        this.status = status;
        this.total_price = total_price;
        this.total_item = total_item;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public HtransInsertResponse() {
    }
}
