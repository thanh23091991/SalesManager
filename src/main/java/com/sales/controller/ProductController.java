package com.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sales.model.Products;
import com.sales.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/product")
	public ResponseEntity<List<Products>> listProduct() {
		List<Products> listProduct = productService.findProduct();
		if(listProduct.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Products>>(listProduct, HttpStatus.OK);
	}
	
	@PostMapping(value = "/product")
	public ResponseEntity<Products> insertProduct(@RequestBody Products Product) {
		if(Product == null || Product.equals("")) {
			return new ResponseEntity<Products>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Products>(productService.addProducts(Product),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/product")
	public ResponseEntity<Products> updateProduct(@RequestBody Products Product) {
		if(!productService.checkExits(Product)) {
			return new ResponseEntity<Products>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Products>(productService.editProducts(Product),HttpStatus.OK); 	
	}
	
	@DeleteMapping(value = "/product")
	public ResponseEntity<Boolean> deleteProduct(@RequestParam("ProductId") int ProductId) {
		if(!productService.deleteProducts(ProductId)) {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		
	}
}
