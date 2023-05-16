package com.mbokmu.tokopi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Temporal(TemporalType.TIMESTAMP)
    Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    Date updated_at;

    @PrePersist
    protected void onCreate() {
        created_at = updated_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = new Date();
    }
}
