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

import com.sales.model.Unit;
import com.sales.service.UnitService;

@RestController
public class UnitController {
	@Autowired
	private UnitService unitService;
	
	@GetMapping(value = "/unit")
	public ResponseEntity<List<Unit>> listUnit() {
		List<Unit> listunit = unitService.findUnit();
		if(listunit.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Unit>>(listunit, HttpStatus.OK);
	}
	
	@PostMapping(value = "/unit")
	public ResponseEntity<Unit> insertunit(@RequestBody Unit unit) {
		if(unit == null || unit.equals("")) {
			return new ResponseEntity<Unit>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Unit>(unitService.addUnit(unit),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/unit")
	public ResponseEntity<Unit> updateunit(@RequestBody Unit unit) {
		if(!unitService.checkExits(unit)) {
			return new ResponseEntity<Unit>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Unit>(unitService.editUnit(unit),HttpStatus.OK); 	
	}
	
	@DeleteMapping(value = "/unit")
	public ResponseEntity<Boolean> deleteunit(@RequestParam("unitId") int unitId) {
		if(!unitService.deleteUnit(unitId)) {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		
	}
}
