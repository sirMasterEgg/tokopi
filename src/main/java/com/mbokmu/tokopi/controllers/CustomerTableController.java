package com.mbokmu.tokopi.controllers;

import com.mbokmu.tokopi.dto.response.CustomerTableInsertResponse;
import com.mbokmu.tokopi.models.CustomerTable;
import com.mbokmu.tokopi.services.CustomerTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/table")
public class CustomerTableController {
    @Autowired
    CustomerTableService service;

    @PostMapping("")
    public ResponseEntity<CustomerTableInsertResponse> save(@RequestBody CustomerTable table) {
        var result = service.save(table);
        return ResponseEntity.ok(result);
    }
}
