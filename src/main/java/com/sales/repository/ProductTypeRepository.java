package com.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.model.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

}
