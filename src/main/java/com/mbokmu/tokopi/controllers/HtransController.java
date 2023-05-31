package com.mbokmu.tokopi.controllers;

import com.mbokmu.tokopi.models.Htrans;
import com.mbokmu.tokopi.services.HtransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/htrans")
public class HtransController {
    @Autowired
    HtransService service;

    @PostMapping("")
    public ResponseEntity<Htrans> save(@RequestBody Htrans obj) {
        service.save(obj);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("")
    public List<Htrans> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Htrans> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
