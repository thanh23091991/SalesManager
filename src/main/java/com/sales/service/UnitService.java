package com.sales.service;

import java.util.List;

import com.sales.model.Unit;

public interface UnitService {
	public List<Unit> findUnit();
	
	public Unit addUnit(Unit unit);
	
	public Unit editUnit(Unit unit);
	
	public boolean deleteUnit(int unittId);
	
	public boolean checkExits(Unit unit);
}
