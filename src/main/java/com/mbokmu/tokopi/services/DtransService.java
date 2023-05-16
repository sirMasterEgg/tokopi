package com.mbokmu.tokopi.services;

import com.mbokmu.tokopi.models.Dtrans;
import com.mbokmu.tokopi.repositories.DtransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DtransService {
    @Autowired
    DtransRepository repository;

    public void save(Dtrans obj) {
        repository.save(obj);
    }

    public List<Dtrans> findAll() {
        return repository.findAll();
    }

    public Optional<Dtrans> findById(Integer id) {
        return repository.findById(id);
    }
}