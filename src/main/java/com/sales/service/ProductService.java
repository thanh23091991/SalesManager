package com.sales.service;

import java.util.List;

import com.sales.model.Products;

public interface ProductService {
	public List<Products> findProduct();
	
	public Products addProducts(Products product);
	
	public Products editProducts(Products product);
	
	public boolean deleteProducts(int producttId);
	
	public boolean checkExits(Products product);
}
