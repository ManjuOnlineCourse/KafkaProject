package com.my.hotel.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.hotel.Entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{
	
	public Account findByAccNo(int accNo);
	
	public List<Account> findByName(String name);
	
}
