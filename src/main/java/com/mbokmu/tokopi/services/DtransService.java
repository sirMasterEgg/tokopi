package com.mbokmu.tokopi.services;

import com.mbokmu.tokopi.dto.DtransDto;
import com.mbokmu.tokopi.dto.DtransUpdateDto;
import com.mbokmu.tokopi.models.Dtrans;
import com.mbokmu.tokopi.models.Htrans;
import com.mbokmu.tokopi.models.Menu;
import com.mbokmu.tokopi.repositories.DtransRepository;
import com.mbokmu.tokopi.repositories.HtransRepository;
import com.mbokmu.tokopi.repositories.MenuRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Dtrans save(Dtrans obj) {
        List<Dtrans> dtransList = null;
        Htrans htrans = htransRepository.findById(obj.getHtrans().getId()).get();
        dtransList = htrans.getDtrans();
        dtransList.add(obj);
        htrans.setDtrans(dtransList);
        return repository.save(obj);
    }

    public List<Dtrans> findAll() {
        return repository.findAll();
    }

    public Optional<Dtrans> findById(Integer id) {
        return repository.findById(id);
    }

    private Htrans convertToHtrans(DtransDto dto) {
        // Fetch the Htrans entity from the database using the htransId
        Htrans htrans = htransRepository.findById(dto.getHtrans_id()).orElseThrow(() -> new EntityNotFoundException("Htrans not found"));

        return htrans;
    }
    private Menu convertToMenu(DtransDto dto) {
        // Fetch the Htrans entity from the database using the htransId
        Menu menu = menuRepository.findById(dto.getMenu_id()).orElseThrow(() -> new EntityNotFoundException("Menu not found"));

        return menu;
    }

    public Dtrans saveWithDto(DtransDto obj){
        Dtrans dtrans = new Dtrans();
        int subtotal = obj.getQty() * obj.getPrice();
        dtrans.setHtrans(convertToHtrans(obj));
        dtrans.setMenu(convertToMenu(obj));
        dtrans.setQty(obj.getQty());
        dtrans.setPrice(obj.getPrice());
        dtrans.setSubtotal(subtotal);
        dtrans.setStatus(obj.getStatus());

        Htrans htrans = htransRepository.findById(obj.getHtrans_id()).get();
        htrans.setTotal_price(htrans.getTotal_price() + subtotal);
        htrans.setTotal_item(htrans.getTotal_item() + obj.getQty());

        htransRepository.save(htrans);

        return save(dtrans);
    }

    public Dtrans updateStatus(DtransUpdateDto obj) {
        Dtrans dtrans = repository.findById(obj.getId()).get();
        dtrans.setStatus(obj.getStatus());
        return repository.save(dtrans);
    }

}