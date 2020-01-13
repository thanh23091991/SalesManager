package com.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.model.Vender;

public interface VenderRepository extends JpaRepository<Vender, Integer> {

}
