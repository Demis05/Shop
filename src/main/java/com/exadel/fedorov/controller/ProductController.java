package com.exadel.fedorov.controller;


import com.exadel.fedorov.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.exadel.fedorov.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView getProducts() {
        List<Product> products = productService.getProducts();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("products", products);
        return mav;
    }
}
