package com.mbokmu.tokopi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HtransInsertDto {
    String table_number;
    String status;
}
