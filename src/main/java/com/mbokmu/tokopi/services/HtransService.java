package com.mbokmu.tokopi.services;

import com.mbokmu.tokopi.dto.HtransInsertDto;
import com.mbokmu.tokopi.dto.HtransUpdateDto;
import com.mbokmu.tokopi.dto.response.HtransFindResponse;
import com.mbokmu.tokopi.dto.response.HtransInsertResponse;
import com.mbokmu.tokopi.models.CustomerTable;
import com.mbokmu.tokopi.models.Htrans;
import com.mbokmu.tokopi.repositories.CustomerTableRepository;
import com.mbokmu.tokopi.repositories.HtransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HtransService {
    @Autowired
    HtransRepository repository;
    @Autowired
    CustomerTableRepository customerTableRepository;

    public void save(Htrans obj) {
        repository.save(obj);
    }

    public List<HtransFindResponse> findAll() {
        var htrans = repository.findAll();

        List<HtransFindResponse> result = new ArrayList<>();

        for (Htrans ht : htrans){
            var table = ht.getTable() == null ? null : ht.getTable().getTable_number();

            result.add(new HtransFindResponse(
                    ht.getId(),
                    table,
                    ht.getStatus(),
                    ht.getTotal_price(),
                    ht.getTotal_item(),
                    ht.getCreated_at(),
                    ht.getUpdated_at(),
                    ht.getDtrans()
            ));
        }

        return result;
    }

    public Optional<HtransFindResponse> findById(Integer id) {
        var htrans = repository.findById(id).get();
        var table = htrans.getTable() == null ? null : htrans.getTable().getTable_number();

        return Optional.of(new HtransFindResponse(
                htrans.getId(),
                table,
                htrans.getStatus(),
                htrans.getTotal_price(),
                htrans.getTotal_item(),
                htrans.getCreated_at(),
                htrans.getUpdated_at(),
                htrans.getDtrans()
        ));
    }

    public HtransFindResponse updateStatus(HtransUpdateDto obj) {
        Htrans htrans = repository.findById(obj.getId()).get();
        htrans.setStatus(obj.getStatus());
        var newResult = repository.save(htrans);

        var table = newResult.getTable() == null ? null : newResult.getTable().getTable_number();
        return new HtransFindResponse(
                newResult.getId(),
                table,
                newResult.getStatus(),
                newResult.getTotal_price(),
                newResult.getTotal_item(),
                newResult.getCreated_at(),
                newResult.getUpdated_at(),
                newResult.getDtrans()
        );
    }

    public HtransInsertResponse insert(HtransInsertDto obj) {
        Htrans htrans = new Htrans();
        var table = customerTableRepository.findTableIdByTableNumber(obj.getTable_number());

        if (table == null){
            return null;
        }

        htrans.setTable(table);
        htrans.setStatus("Pending");
        var result = repository.save(htrans);
        return new HtransInsertResponse(
                result.getId(),
                table.getTable_number(),
                result.getStatus(),
                result.getTotal_price(),
                result.getTotal_item(),
                result.getCreated_at(),
                result.getUpdated_at()
        );
    }
}