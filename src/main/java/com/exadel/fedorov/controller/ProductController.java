package com.exadel.fedorov.controller;

import com.exadel.fedorov.domain.Product;
import com.exadel.fedorov.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/products")
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getProducts() {
        List<Product> products = productService.getProducts();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("products", products);
        return mav;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getProductById(@PathVariable("id") Long productId) {
        Product product = productService.getProductById(productId);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("product", product);
        return mav;
    }


    /*
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteProductById(@PathVariable("id") Long productId) {
        Product product = productService.getProductById(productId);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ModelAndView updateProductById(@PathVariable("id") Long productId) {
        Product product = productService.getProductById(productId);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("product", product);
        return mav;
    }*/
}
