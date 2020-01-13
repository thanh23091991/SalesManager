package com.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.model.Unit;
import com.sales.repository.UnitRepository;
import com.sales.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService{
	@Autowired
	private UnitRepository unitRepository;
	
	@Override
	public List<Unit> findUnit() {
		return unitRepository.findAll();
	}

	@Override
	public Unit addUnit(Unit unit) {
		Unit insertUnit = new Unit();
		insertUnit.setUnitName(unit.getUnitName());
		return unitRepository.save(insertUnit);
	}

	@Override
	public Unit editUnit(Unit unit) {
		Unit updateUnit = unitRepository.getOne(unit.getUnitId());
		updateUnit.setUnitName(unit.getUnitName());
		return unitRepository.save(updateUnit);
	}

	@Override
	public boolean deleteUnit(int unittId) {
		if(unitRepository.existsById(unittId)) {
			unitRepository.deleteById(unittId);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkExits(Unit unit) {
		if(unitRepository.existsById(unit.getUnitId())) {
			return true;
		}
		return false;
	}

}
