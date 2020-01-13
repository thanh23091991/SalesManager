package com.sales.service;

import java.util.List;

import com.sales.model.Vender;

public interface VenderService {
	public List<Vender> findVender();
	
	public Vender addVender(Vender vender);
	
	public Vender editVender(Vender vender);
	
	public boolean deleteVender(int venderId);
	
	public boolean checkExits(Vender vender);
}
