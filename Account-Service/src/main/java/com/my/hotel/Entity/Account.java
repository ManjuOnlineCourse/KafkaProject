package com.my.hotel.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accId;
	
	@Column
	private int accNo;
	
	@Column
	private String Name;
	
	@Column
	private double balance;
	
	

	
}
