package com.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.model.Vender;
import com.sales.repository.VenderRepository;
import com.sales.service.VenderService;

@Service
public class VenderServiceImpl implements VenderService {
	@Autowired
	private VenderRepository venderRepository;
	
	@Override
	public List<Vender> findVender() {
		return venderRepository.findAll();
	}

	@Override
	public Vender addVender(Vender vender) {
		Vender insertVender = new Vender();
		insertVender.setVenderName(vender.getVenderName());
		insertVender.setDescription(vender.getDescription());
		insertVender.setEmail(vender.getEmail());
		insertVender.setStatus(vender.getStatus());
		return venderRepository.save(insertVender);
	}

	@Override
	public Vender editVender(Vender vender) {
		Vender updateVender = venderRepository.getOne(vender.getVenderId());
		updateVender.setVenderName(vender.getVenderName());
		updateVender.setDescription(vender.getDescription());
		updateVender.setEmail(vender.getEmail());
		updateVender.setStatus(vender.getStatus());
		return venderRepository.save(updateVender);
	}

	@Override
	public boolean deleteVender(int venderId) {
		if(venderRepository.existsById(venderId)) {
			venderRepository.deleteById(venderId);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkExits(Vender vender) {
		if(venderRepository.existsById(vender.getVenderId())) {
			return true;
		}
		return false;
	}

}
