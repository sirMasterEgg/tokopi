package com.mbokmu.tokopi.dto.response;

import com.mbokmu.tokopi.models.Dtrans;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class HtransFindResponse extends HtransInsertResponse {
    private List<Dtrans> dtrans;

    public HtransFindResponse(int id, String table_number, String status, int total_price, int total_item, Date created_at, Date updated_at, List<Dtrans> dtrans) {
        super(id, table_number, status, total_price, total_item, created_at, updated_at);
        this.dtrans = dtrans;
    }

    public HtransFindResponse() {
    }
}
