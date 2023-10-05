package com.example.naresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.naresh.entity.Product;
import com.example.naresh.serivice.ProductService;
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	 private ProductService productService;

  

    @GetMapping("/list")
    public ResponseEntity<Page<Product>> listProducts(
            @RequestParam(name = "page") int page,
            @RequestParam(name = "size") int size,
            @RequestParam(name = "keyword", required = false) String keyword) {

        Page<Product> products = productService.listProducts(page, size, keyword);

        return ResponseEntity.ok(products);
    }

}
