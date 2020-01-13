package com.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.model.Products;
import com.sales.repository.ProductRepository;
import com.sales.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Products> findProduct() {
		return productRepository.findAll();
	}

	@Override
	public Products addProducts(Products product) {
		Products insertProduct = new Products();
		insertProduct.setProductName(product.getProductName());
		insertProduct.setPrice(product.getPrice());
		insertProduct.setPriceCost(product.getPriceCost());
		insertProduct.setUnit(product.getUnit());
		insertProduct.setProductType(product.getProductType());
		return productRepository.save(insertProduct);
	}

	@Override
	public Products editProducts(Products product) {
		Products updateProduct = productRepository.getOne(product.getProductId());
		updateProduct.setProductName(product.getProductName());
		updateProduct.setPrice(product.getPrice());
		updateProduct.setPriceCost(product.getPriceCost());
		updateProduct.setUnit(product.getUnit());
		updateProduct.setProductType(product.getProductType());
		return productRepository.save(updateProduct) ;
	}

	@Override
	public boolean deleteProducts(int producttId) {
		if(productRepository.existsById(producttId)) {
			productRepository.deleteById(producttId);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkExits(Products product) {
		if(productRepository.existsById(product.getProductId())) {
			return true;
		}
		return false;
	}

}
