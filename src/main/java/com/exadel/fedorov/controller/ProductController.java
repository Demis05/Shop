package com.exadel.fedorov.controller;

import com.exadel.fedorov.domain.Brand;
import com.exadel.fedorov.domain.Product;
import com.exadel.fedorov.dto.ProductDto;
import com.exadel.fedorov.service.ProductService;
import com.exadel.fedorov.service.S3ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RequestMapping("/products")
@Controller
public class ProductController {

    public static final String IMAGE_FOLDER_PATH = "storeFiles/images/";
    private static final String REDIRECT_CATALOG = "redirect:/products/";

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private S3ImageService imageService;

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
        System.out.println(productId + "--");
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
    public String createProduct(@ModelAttribute("product") ProductDto productDto, @RequestParam("file") MultipartFile file) {
        Product product = convertToDomain(productDto);
        productService.save(product);
        imageService.createImage(product.getId(), file);
        return REDIRECT_CATALOG;
    }

    //UPDATE
    @PostMapping(value = "/update")
    public String updateProduct(@ModelAttribute("product") ProductDto productDto, @RequestParam("file") MultipartFile file) {
        Product product = convertToDomain(productDto);
        product.setId(productDto.getId());
        productService.update(product);
        imageService.updateImage(productDto.getId(), file);
        return REDIRECT_CATALOG;
    }

    //DELETE
    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        productService.delete(id);
        imageService.deleteImage(id);
        return REDIRECT_CATALOG;
    }

    private ProductDto convertToDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        productDto.setBrand(product.getBrand().getName());
        String imageName = String.format(IMAGE_FOLDER_PATH + "%d.jpeg", product.getId());
        productDto.setImagePath(imageName);
        return productDto;
    }

    private Product convertToDomain(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product.setBrand(new Brand(productDto.getBrand()));
        return product;
    }
}
