package com.sales.service;

import java.util.List;

import com.sales.model.ProductType;

public interface ProductTypeService {
	public List<ProductType> findProductType();
	
	public ProductType addProductType(ProductType productType);
	
	public ProductType editProductType(ProductType productType);
	
	public boolean deleteProductType(int productTypeId);
	
	public boolean checkExits(ProductType productType);
}
