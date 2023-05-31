package com.mbokmu.tokopi.controllers;

import com.mbokmu.tokopi.models.Menu;
import com.mbokmu.tokopi.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    MenuService service;

    @PostMapping("")
    public ResponseEntity<Menu> save(@RequestBody Menu obj) {
        service.save(obj);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("")
    public List<Menu> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Menu> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
