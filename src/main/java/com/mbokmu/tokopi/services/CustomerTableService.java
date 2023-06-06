package com.mbokmu.tokopi.services;

import com.mbokmu.tokopi.dto.response.CustomerTableInsertResponse;
import com.mbokmu.tokopi.models.CustomerTable;
import com.mbokmu.tokopi.repositories.CustomerTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerTableService {
    @Autowired
    CustomerTableRepository repository;

    public CustomerTableInsertResponse save(CustomerTable obj) {
        var result = repository.save(obj);
        return new CustomerTableInsertResponse(result.getId(), result.getTable_number());
    }

    public Optional<CustomerTable> findByTableNumber(String tableNumber) {
        return Optional.ofNullable(repository.findTableIdByTableNumber(tableNumber));
    }

}
