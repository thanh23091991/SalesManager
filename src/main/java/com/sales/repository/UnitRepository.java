package com.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.model.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer>{

}
