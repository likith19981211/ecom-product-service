package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.ProductRequest;
import com.ecommerce.productcatalog.dto.ProductResponse;
import com.ecommerce.productcatalog.model.Product;
import com.ecommerce.productcatalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public void updateProduct(ProductRequest productRequest) {
        Product product = new Product();
        product = productRepository.findById(productRequest.getId()).get();
        product.setName(productRequest.getName());
        product.setDescription(product.getDescription());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
        log.info("product {} has been updated successfully", product.getId());
    }
}
