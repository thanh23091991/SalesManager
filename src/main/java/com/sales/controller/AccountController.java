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

import com.sales.model.Account;
import com.sales.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = "/account")
	public ResponseEntity<List<Account>> listAccount() {
		List<Account> listAccount = accountService.findAccount();
		if(listAccount.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Account>>(listAccount, HttpStatus.OK);
	}
	
	@PostMapping(value = "/account")
	public ResponseEntity<Account> insertAccount(@RequestBody Account account) {
		if(account == null || account.equals("")) {
			return new ResponseEntity<Account>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Account>(accountService.addAccount(account),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/account")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
		if(!accountService.checkExits(account)) {
			return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Account>(accountService.editAccount(account),HttpStatus.OK); 	
	}
	
	@DeleteMapping(value = "/account")
	public ResponseEntity<Boolean> deleteAccount(@RequestParam("accountId") int accountId) {
		if(!accountService.deleteAccount(accountId)) {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		
	}
}
