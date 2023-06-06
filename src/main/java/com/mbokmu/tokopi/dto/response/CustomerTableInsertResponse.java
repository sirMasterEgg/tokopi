package com.mbokmu.tokopi.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerTableInsertResponse {
    int id;
    String table_number;

    public CustomerTableInsertResponse(int id, String table_number) {
        this.id = id;
        this.table_number = table_number;
    }

    public CustomerTableInsertResponse() {
    }
}
