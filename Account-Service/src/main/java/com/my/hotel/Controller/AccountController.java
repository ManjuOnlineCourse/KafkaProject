package com.my.hotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.hotel.Entity.Account;
import com.my.hotel.Service.AccountService;

@RestController
@RequestMapping("/acc/api/")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable long id){
		
		Account account = accountService.getAccount(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Account>> getAccount(){
		
		List<Account> allAccount = accountService.getAllAccount();
		return new ResponseEntity<List<Account>>(allAccount, HttpStatus.OK);
		
	}
	
	@GetMapping("/accNo/{accNo}")
	public ResponseEntity<Account> getAccount(@PathVariable int accNo){
		
		Account account = accountService.getByAccNo(accNo);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
		
	}

}
