package com.exadel.fedorov.rest;


import com.exadel.fedorov.domain.Product;
import com.exadel.fedorov.dto.ProductDto;
import com.exadel.fedorov.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequestMapping("/rest/products/")
@RestController
public class ProductRest {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = productService.getProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<ProductDto> dtoList = products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long productId) {
        if (productId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = productService.getProductById(productId);
        if (Objects.isNull(product)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProductDto productDto = convertToDto(product);

        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDto productDto) {
        HttpHeaders headers = new HttpHeaders();
        if (productDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productService.save(convertToDomain(productDto));
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        HttpHeaders headers = new HttpHeaders();
        if (productDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productService.update(convertToDomain(productDto));
        return new ResponseEntity<>(productDto, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {//TODO Может поменять на войд и добавить респонс статус анот
        Product product = productService.getProductById(id);

        if (Objects.isNull(product)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    private ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product convertToDomain(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}

