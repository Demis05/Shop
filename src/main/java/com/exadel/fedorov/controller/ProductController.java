package com.exadel.fedorov.controller;

import com.exadel.fedorov.domain.Brand;
import com.exadel.fedorov.domain.Product;
import com.exadel.fedorov.domain.ProductType;
import com.exadel.fedorov.dto.ProductDto;
import com.exadel.fedorov.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/products")
@Controller
public class ProductController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ProductService productService;

    //OPEN NEW PAGE
    @GetMapping("/creating")
    public String newProductForm(Map<String, Object> model) {
        ProductDto productDto = new ProductDto();
        model.put("product", productDto);
        return "new_product";
    }

    //OPEN EDIT PAGE
    @GetMapping("/editing")
    public ModelAndView editProductForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_product");
        ProductDto productDto = convertToDto(productService.getProductById(id));
        mav.addObject("product", productDto);
        return mav;
    }

    //GET
    @GetMapping(value = "/search")
    public ModelAndView getProductById(@RequestParam long productId) {
        Product product = productService.getProductById(productId);
        List<ProductDto> products = Collections.singletonList(convertToDto(product));
        ModelAndView mav = new ModelAndView("catalog");
        mav.addObject("products", products);
        return mav;
    }

    //GET ALL
    @GetMapping
    public ModelAndView getProducts() {
        List<Product> products = productService.getProducts();
        List<ProductDto> dtoList = products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("catalog");
        mav.addObject("products", dtoList);
        return mav;
    }

    //CREATE
    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute("product") ProductDto productDto) {
        Product product = convertToDomain(productDto);
        productService.save(product);
        return "redirect:/products/";
    }

    //UPDATE
    @PostMapping(value = "/update")
    public String updateProduct(@ModelAttribute("product") ProductDto productDto) {
        Product product = convertToDomain(productDto);
        productService.update(product);
        return "redirect:/products/";
    }

    //DELETE
    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        productService.delete(id);
        return "redirect:/products/";
    }

    private ProductDto convertToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setBrand(product.getBrand().getName());
        productDto.setId(product.getId());
        productDto.setType(product.getType().name());
        productDto.setTitle(product.getTitle());
        productDto.setCost(product.getCost());
        productDto.setName(product.getName());
        return productDto;//        return modelMapper.map(product, ProductDto.class);
    }

    private Product convertToDomain(ProductDto productDto) {
        Product product = new Product();
        product.setCost(productDto.getCost());
        product.setName(productDto.getName());
        product.setTitle(productDto.getTitle());
        product.setType(ProductType.valueOf(productDto.getType()));
        product.setBrand(new Brand(0L, productDto.getBrand()));
        return product;//return modelMapper.map(productDto, Product.class);
    }
}
