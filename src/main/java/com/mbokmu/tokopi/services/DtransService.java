package com.mbokmu.tokopi.services;

import com.mbokmu.tokopi.models.Dtrans;
import com.mbokmu.tokopi.models.Htrans;
import com.mbokmu.tokopi.models.Menu;
import com.mbokmu.tokopi.repositories.DtransRepository;
import com.mbokmu.tokopi.repositories.HtransRepository;
import com.mbokmu.tokopi.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DtransService {
    @Autowired
    DtransRepository repository;

    @Autowired
    HtransRepository htransRepository;

    @Autowired
    MenuRepository menuRepository;

    public void save(Dtrans obj) {
        List<Dtrans> dtransList = null;
        Htrans htrans = htransRepository.findById(obj.getHtrans().getId()).get();
        dtransList = htrans.getDtrans();
        dtransList.add(obj);
        htrans.setDtrans(dtransList);
        repository.save(obj);
    }

    public List<Dtrans> findAll() {
        return repository.findAll();
    }

    public Optional<Dtrans> findById(Integer id) {
        return repository.findById(id);
    }
}