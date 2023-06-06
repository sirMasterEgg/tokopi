package com.mbokmu.tokopi.repositories;

import com.mbokmu.tokopi.models.CustomerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerTableRepository extends JpaRepository<CustomerTable, Integer> {
    @Query("select ct from CustomerTable ct where ct.table_number = :tableNumber")
    CustomerTable findTableIdByTableNumber(@Param("tableNumber") String tableNumber);
}
