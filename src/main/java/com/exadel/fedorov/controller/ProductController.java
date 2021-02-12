package com.exadel.fedorov.controller;

import com.exadel.fedorov.domain.Product;
import com.exadel.fedorov.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RequestMapping("/products")
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/{id}")
    public ModelAndView getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("product", product);
        return mav;
    }

    //GET ALL
    @GetMapping
    public ModelAndView getProducts() {
        List<Product> products = productService.getProducts();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("products", products);
        return mav;
    }

    //OPEN NEW PAGE
    @GetMapping("/new")
    public String newProductForm(Map<String, Object> model) {
        Product product = new Product();
        model.put("product", product);
        return "new_product";
    }

    //SAVE
    @PostMapping(value = "/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        System.out.println(product);
        productService.update(product);
        return "redirect:/products/";
    }

    //OPEN EDIT PAGE
    @GetMapping("/edit")
    public ModelAndView editProductForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = productService.getProductById(id);
        mav.addObject("product", product);
        return mav;
    }

    //DELETE
    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        productService.delete(id);
        return "redirect:/products/";
    }
}
