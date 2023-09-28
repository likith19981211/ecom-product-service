package com.ecommerce.productcatalog.controller;

import com.ecommerce.productcatalog.dto.ProductRequest;
import com.ecommerce.productcatalog.dto.ProductResponse;
import com.ecommerce.productcatalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody ProductRequest productRequest) {
        productService.updateProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
    return productService.getAllProducts();
    }
}
