package com.example.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="Accounts")
@Entity
public class Account
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CustomerId")
    private int customerId;
	
	@Column(name="First_Name")
     private String firstName;
	
	@Column(name="Last_Name")
    private String lastName;
	
	@Column(name="AccountNumber")
    private String accountNo;
	
	@Column(name="Email")
    private String email;
	
	@Column(name="MobileNumber")
    private String mobileNo;
}
