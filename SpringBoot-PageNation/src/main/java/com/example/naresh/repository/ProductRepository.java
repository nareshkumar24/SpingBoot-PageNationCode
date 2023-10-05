package com.example.naresh.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.naresh.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Page<Product> findByNameContaining(String keyword, PageRequest pageable);

}
