package com.ecommerce.productcatalog.repository;

import com.ecommerce.productcatalog.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository  extends MongoRepository<Product, String> {

}
