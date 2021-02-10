package com.exadel.fedorov.controller;

import com.exadel.fedorov.domain.Product;
import com.exadel.fedorov.domain.ProductType;
import com.exadel.fedorov.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/products")
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView getProducts() {
        List<Product> products = productService.getProducts();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("products", products);
        return mav;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView getProductById(@PathVariable("id") Long productId) {
        Product product = productService.getProductById(productId);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("product", product);
        return mav;
    }

    @PostMapping
    public ModelAndView createProduct(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "cost") Integer cost,
            @RequestParam(value = "type") String type,
            @RequestParam(value = "manufacturerId") Integer manufacturerId

    ) {
        Product product = new Product();
        product.setTitle(title);
        product.setName(name);
        product.setCost(cost);
        product.setType(ProductType.valueOf(type));
        product.setManufacturerId(manufacturerId);
        productService.save(product);
        return new ModelAndView("index");
    }


    @RequestMapping("/edit")
    public ModelAndView editProductForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = productService.getProductById(id);
        mav.addObject("product", product);
        return mav;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        System.out.println(product);
        productService.update(product);
        return "redirect:/products/";
    }

    @PutMapping("/edit")
    public ModelAndView updateProductById(
            @PathVariable("id") Long id,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "cost", required = false) Integer cost,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "manufacturerId", required = false) Integer manufacturerId
    ) {
        Product product = new Product(id, title, name, cost, ProductType.valueOf(type), manufacturerId);
        productService.update(product);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("product", product);


        return mav;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteProductById(@PathVariable("id") Long productId) {
        productService.delete(productId);
        return new ModelAndView("index");
    }
}
