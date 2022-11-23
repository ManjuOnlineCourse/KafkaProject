package com.my.hotel;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.hotel.Entity.Account;

@SpringBootApplication
public class OrderServiceApplication {
	private static final String getAcc = "http://localhost:9001/acc/api/1";
	
	static RestTemplate restTemplate=new RestTemplate();
	
	public static void main(String[] args){
		SpringApplication.run(OrderServiceApplication.class, args);
		try {
			System.out.println(callGetAcc());
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	private static Long callGetAcc() throws JsonMappingException, JsonProcessingException {
		HttpHeaders headers =new  HttpHeaders();
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity= new HttpEntity<>(headers);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(getAcc, HttpMethod.GET, entity, String.class);
		
		System.out.println(responseEntity.getBody());
		
		ObjectMapper mapper = new ObjectMapper();
		
			Account account = mapper.readValue(responseEntity.getBody().toString(), Account.class);
			System.out.println("account.getAccId "+account.getAccId());
			System.out.println("account.getAccNumber "+account.getAccNo());
			System.out.println("account.getAccBalance "+account.getBalance());
			return account.getAccId();

	}
	
	

}
