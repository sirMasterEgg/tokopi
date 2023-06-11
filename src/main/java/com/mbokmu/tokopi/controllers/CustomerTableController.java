package com.mbokmu.tokopi.controllers;

import com.mbokmu.tokopi.dto.response.CustomerTableInsertResponse;
import com.mbokmu.tokopi.models.CustomerTable;
import com.mbokmu.tokopi.services.CustomerTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("")
    public List<CustomerTable> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CustomerTable> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
