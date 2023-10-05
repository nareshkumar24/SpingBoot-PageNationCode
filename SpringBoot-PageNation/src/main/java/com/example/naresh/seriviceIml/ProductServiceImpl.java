package com.example.naresh.seriviceIml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.naresh.entity.Product;
import com.example.naresh.repository.ProductRepository;
import com.example.naresh.serivice.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Page<Product> listProducts(int page, int size, String keyword) {
		
		PageRequest pageable = PageRequest.of(page, size);

	    if (keyword != null && !keyword.isEmpty()) {
	        // If a keyword is provided, search for products containing the keyword in their names
	        return productRepository.findByNameContaining(keyword, pageable);
	    } else {
	        // If no keyword is provided, return all products with pagination
	        return productRepository.findAll(pageable);
	    }
	}

}
