package com.my.hotel.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.hotel.Entity.Account;
import com.my.hotel.Repo.AccountRepo;
import com.my.hotel.Service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepo accountRepo;

	
	
	@Override
	public Account getAccount(long id) {
		Account account = accountRepo.findById(id).orElseThrow();
		return account;
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> allAcc = accountRepo.findAll();
		return allAcc;
	}

	@Override
	public Account getByAccNo(int accNo) {
		Account acc = accountRepo.findByAccNo(accNo);
				return acc;
	}

	@Override
	public List<Account> getByName(String name) {
		List<Account> acc = accountRepo.findByName(name);
		return acc;
	}



}
