package com.mbokmu.tokopi.controllers;

import com.mbokmu.tokopi.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    final MenuController menuController;

    @Autowired
    public PageController(MenuController menuController) {
        this.menuController = menuController;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/order")
    public String order() {
        return "order";
    }
    @RequestMapping("/menu")
    public String menu(Model model) {
        List<Menu> menus = menuController.findAll();
        model.addAttribute("menus", menus);
        return "menu";
    }
}
