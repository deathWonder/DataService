package com.example.dataaccessobject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final ProductService service;

    public Controller(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    private String mainMethod(@RequestParam("name") String name) {
        return service.getProducts(name);
    }
}
