package com.mbokmu.tokopi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/order")
    public String order() {
        return "order";
    }
    @RequestMapping("/menu")
    public String menu() {
        return "menu";
    }
}
