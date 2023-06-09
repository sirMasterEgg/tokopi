package com.mbokmu.tokopi.controllers;

import com.mbokmu.tokopi.dto.DtransDto;
import com.mbokmu.tokopi.dto.DtransUpdateDto;
import com.mbokmu.tokopi.dto.HtransUpdateDto;
import com.mbokmu.tokopi.models.Dtrans;
import com.mbokmu.tokopi.models.Htrans;
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
    public ResponseEntity<Dtrans> save(@RequestBody DtransDto obj) {
        Dtrans result = service.saveWithDto(obj);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public List<Dtrans> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Dtrans> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PatchMapping("/update-status")
    public ResponseEntity<Dtrans> updateStatus(@RequestBody DtransUpdateDto obj) {
        Dtrans result = service.updateStatus(obj);
        return ResponseEntity.ok(result);
    }

}
