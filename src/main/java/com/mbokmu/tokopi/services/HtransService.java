package com.mbokmu.tokopi.services;

import com.mbokmu.tokopi.dto.HtransUpdateDto;
import com.mbokmu.tokopi.models.Htrans;
import com.mbokmu.tokopi.repositories.HtransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HtransService {
    @Autowired
    HtransRepository repository;

    public void save(Htrans obj) {
        repository.save(obj);
    }

    public List<Htrans> findAll() {
        return repository.findAll();
    }

    public Optional<Htrans> findById(Integer id) {
        return repository.findById(id);
    }

    public Htrans updateStatus(HtransUpdateDto obj) {
        Htrans htrans = repository.findById(obj.getId()).get();
        htrans.setStatus(obj.getStatus());
        return repository.save(htrans);
    }
}