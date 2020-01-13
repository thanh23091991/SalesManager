package com.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sales.model.ProductType;
import com.sales.service.ProductTypeService;

@RestController
public class ProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;

	@GetMapping(value = "/productType")
	public ResponseEntity<List<ProductType>> listProductType() {
		List<ProductType> listProductType = productTypeService.findProductType();
		if (listProductType.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProductType>>(listProductType, HttpStatus.OK);
	}

	@PostMapping(value = "/productType")
	public ResponseEntity<ProductType> insertProductType(@RequestBody ProductType productType) {
		if (productType == null || productType.equals("")) {
			return new ResponseEntity<ProductType>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<ProductType>(productTypeService.addProductType(productType), HttpStatus.CREATED);
	}

	@PutMapping(value = "/productType")
	public ResponseEntity<ProductType> updateProductType(@RequestBody ProductType productType) {
		if (!productTypeService.checkExits(productType)) {
			return new ResponseEntity<ProductType>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ProductType>(productTypeService.editProductType(productType), HttpStatus.OK);
	}

	@DeleteMapping(value = "/productType")
	public ResponseEntity<Boolean> deleteProductType(@RequestParam("productTypeId") int productTypeId) {
		if (!productTypeService.deleteProductType(productTypeId)) {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);

	}
}
