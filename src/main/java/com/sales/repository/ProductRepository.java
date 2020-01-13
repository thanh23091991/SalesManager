package com.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>{

}
