package com.sales.service;

import java.util.List;

import com.sales.model.Account;

public interface AccountService {
	public List<Account> findAccount();
	
	public Account addAccount(Account account);
	
	public Account editAccount(Account account);
	
	public boolean deleteAccount(int accountId);
	
	public boolean checkExits(Account account);
}
