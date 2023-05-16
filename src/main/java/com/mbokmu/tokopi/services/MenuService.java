package com.mbokmu.tokopi.services;

import com.mbokmu.tokopi.models.Menu;
import com.mbokmu.tokopi.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    MenuRepository repository;

    public void save(Menu obj) {
        repository.save(obj);
    }

    public List<Menu> findAll() {
        return repository.findAll();
    }

    public Optional<Menu> findById(Integer id) {
        return repository.findById(id);
    }
}