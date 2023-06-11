package com.mbokmu.tokopi.controllers;

import com.mbokmu.tokopi.dto.DtransDto;
import com.mbokmu.tokopi.dto.HtransInsertDto;
import com.mbokmu.tokopi.dto.response.HtransFindResponse;
import com.mbokmu.tokopi.models.CustomerTable;
import com.mbokmu.tokopi.models.Dtrans;
import com.mbokmu.tokopi.models.Htrans;
import com.mbokmu.tokopi.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class PageController {

    final MenuController menuController;
    final CustomerTableController tableController;
    final HtransController htransController;
    final DtransController dtransController;

    @Autowired
    public PageController(MenuController menuController, CustomerTableController tableController, HtransController htransController, DtransController dtransController) {
        this.menuController = menuController;
        this.tableController = tableController;
        this.htransController = htransController;
        this.dtransController = dtransController;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/menu")
    public String menu(Model model) {
        List<Menu> menus = menuController.findAll();
        model.addAttribute("menus", menus);
        return "menu";
    }

    @RequestMapping("/table")
    public String table(Model model) {
        List<CustomerTable> tables = tableController.findAll();
        model.addAttribute("tables", tables);
        model.addAttribute("htrans", new HtransInsertDto());
        return "table";
    }

    @RequestMapping(value = "/table/save", method = RequestMethod.POST)
    public String checkTable(HtransInsertDto htrans) {
        htrans.setStatus("Pending");
        htransController.save(htrans);
        return "redirect:/order/" + htransController.findLast().getId();
    }

    @RequestMapping("/order/{htrans_id}")
    public String order(Model model) {
        List<Menu> menus = menuController.findAll();
        model.addAttribute("menus", menus);
        return "order";
    }

    @RequestMapping(value = "/order/{htrans_id}/save", method = RequestMethod.POST)
    public String doOrder(@RequestBody Map<String, String> map, @PathVariable("htrans_id") String htrans_id) {
        DtransDto dtrans = new DtransDto();
        dtrans.setQty(Integer.parseInt(map.get("qty")));
        dtrans.setPrice(Integer.parseInt(map.get("price")));
        dtrans.setStatus("Pending");
        dtrans.setHtrans_id(Integer.parseInt(htrans_id));
        dtrans.setMenu_id(Integer.parseInt(map.get("menu_id")));
        dtransController.save(dtrans);
        return "redirect:/order/" + htrans_id;
    }

    @RequestMapping("/history")
    public String histories(Model model) {
        List<HtransFindResponse> htransList = htransController.findAll();
        Collections.reverse(htransList);
        model.addAttribute("htransList", htransList);
        return "histories";
    }

    @RequestMapping("/history/{htrans_id}")
    public String history(Model model) {
        List<Dtrans> dtransList = dtransController.findAll();
        model.addAttribute("dtransList", dtransList);
        return "history";
    }
}
