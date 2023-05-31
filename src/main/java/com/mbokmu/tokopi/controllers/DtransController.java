package com.mbokmu.tokopi.controllers;

import com.mbokmu.tokopi.models.Dtrans;
import com.mbokmu.tokopi.services.DtransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dtrans")
public class DtransController {
    @Autowired
    DtransService service;

    @PostMapping("")
    public ResponseEntity<Dtrans> save(@RequestBody Dtrans obj) {
        service.save(obj);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("")
    public List<Dtrans> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Dtrans> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
