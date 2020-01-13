package com.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
