package com.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.model.Account;
import com.sales.repository.AccountRepository;
import com.sales.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> findAccount() {
		List<Account> listAccount = accountRepository.findAll();
		return listAccount;
	}

	@Override
	public Account addAccount(Account account) {
		Account accountInsert = new Account();
		accountInsert.setAccountName(account.getAccountName());
		accountInsert.setPassword(account.getPassword());
		return accountRepository.save(accountInsert);
	}

	@Override
	public Account editAccount(Account account) {
		Account accountUpdate = accountRepository.getOne(account.getAccountId());
		accountUpdate.setAccountName(account.getAccountName());
		accountUpdate.setPassword(account.getPassword());
		return  accountRepository.save(accountUpdate);
	}

	@Override
	public boolean deleteAccount(int accountId) {
		if(accountRepository.existsById(accountId)) {
			accountRepository.deleteById(accountId);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkExits(Account account) {
		if(accountRepository.existsById(account.getAccountId())) {
			return true;
		}
		return false;
	}

}
