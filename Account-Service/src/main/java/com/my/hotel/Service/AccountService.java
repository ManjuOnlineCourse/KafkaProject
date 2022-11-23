package com.my.hotel.Service;

import java.util.List;

import com.my.hotel.Entity.Account;

public interface AccountService {
	public Account getAccount(long id);
	public List<Account> getAllAccount();
	public Account getByAccNo(int accNo);
	public List<Account> getByName(String name);
	
}
