package com.exadel.fedorov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/shop")
@Controller
public class HomeController {

    @RequestMapping(value = "/products_page")
    public String saveProduct() {
        return "redirect:/shop/products/";
    }

    @GetMapping
    public ModelAndView getProducts() {
        return new ModelAndView("home");
    }
}
