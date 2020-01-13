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

import com.sales.model.Vender;
import com.sales.service.VenderService;

@RestController
public class VenderController {
	
	@Autowired
	private VenderService venderService;
	
	@GetMapping(value = "/vender")
	public ResponseEntity<List<Vender>> listVender() {
		List<Vender> listVender = venderService.findVender();
		if(listVender.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Vender>>(listVender, HttpStatus.OK);
	}
	
	@PostMapping(value = "/vender")
	public ResponseEntity<Vender> insertVender(@RequestBody Vender vender) {
		if(vender == null || vender.equals("")) {
			return new ResponseEntity<Vender>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Vender>(venderService.addVender(vender),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/vender")
	public ResponseEntity<Vender> updateVender(@RequestBody Vender vender) {
		if(!venderService.checkExits(vender)) {
			return new ResponseEntity<Vender>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Vender>(venderService.editVender(vender),HttpStatus.OK); 	
	}
	
	@DeleteMapping(value = "/vender")
	public ResponseEntity<Boolean> deleteVender(@RequestParam("venderId") int venderId) {
		if(!venderService.deleteVender(venderId)) {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		
	}
}
