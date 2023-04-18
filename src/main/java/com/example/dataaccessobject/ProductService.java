package com.example.dataaccessobject;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public String getProducts(String name) {
        return repository.getProductName(name);
    }


}
