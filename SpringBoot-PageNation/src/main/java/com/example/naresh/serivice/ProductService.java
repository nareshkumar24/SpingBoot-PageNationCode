package com.example.naresh.serivice;

import org.springframework.data.domain.Page;

import com.example.naresh.entity.Product;

public interface ProductService {

	Page<Product> listProducts(int page, int size, String keyword);
}
