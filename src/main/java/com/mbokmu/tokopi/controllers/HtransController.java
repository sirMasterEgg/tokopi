package com.mbokmu.tokopi.controllers;

import com.mbokmu.tokopi.dto.HtransInsertDto;
import com.mbokmu.tokopi.dto.HtransUpdateDto;
import com.mbokmu.tokopi.dto.response.HtransFindResponse;
import com.mbokmu.tokopi.dto.response.HtransInsertResponse;
import com.mbokmu.tokopi.models.Htrans;
import com.mbokmu.tokopi.services.CustomerTableService;
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
    public ResponseEntity<HtransInsertResponse> save(@RequestBody HtransInsertDto obj) {
        var result = service.insert(obj);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public List<HtransFindResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/htrans/last")
    public Htrans findLast() {
        return service.findLast();
    }

    @GetMapping("/{id}")
    public Optional<HtransFindResponse> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PatchMapping("/update-status")
    public ResponseEntity<HtransFindResponse> updateStatus(@RequestBody HtransUpdateDto obj) {
        HtransFindResponse result = service.updateStatus(obj);
        return ResponseEntity.ok(result);
    }
}
