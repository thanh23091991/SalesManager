package com.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.model.ProductType;
import com.sales.repository.ProductTypeRepository;
import com.sales.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Override
	public List<ProductType> findProductType() {
		return productTypeRepository.findAll();
	}

	@Override
	public ProductType addProductType(ProductType productType) {
		ProductType insertProductType = new ProductType();
		insertProductType.setProductTypeName(productType.getProductTypeName());
		insertProductType.setProductTypeParent(productType.getProductTypeParent());
		return productTypeRepository.save(insertProductType);
	}

	@Override
	public ProductType editProductType(ProductType productType) {
		ProductType updateProductType = productTypeRepository.getOne(productType.getProductTypeId());
		updateProductType.setProductTypeName(productType.getProductTypeName());
		updateProductType.setProductTypeParent(productType.getProductTypeParent());
		return productTypeRepository.save(updateProductType);
	}

	@Override
	public boolean deleteProductType(int productTypeId) {
		if(productTypeRepository.existsById(productTypeId)) {
			productTypeRepository.deleteById(productTypeId);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkExits(ProductType productType) {
		if(productTypeRepository.existsById(productType.getProductTypeId())) {
			return true;
		}
		return false;
	}

}
