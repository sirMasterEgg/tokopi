package com.mbokmu.tokopi.repositories;

import com.mbokmu.tokopi.models.Htrans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HtransRepository extends JpaRepository<Htrans, Integer> {
    @Query("SELECT htrans FROM Htrans htrans ORDER BY htrans.id DESC LIMIT 1")
    Htrans findLast();
}
