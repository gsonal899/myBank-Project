package com.example.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardDto 
{
	  private long cardId;
	  private String cardNumber;
	  private String cardType;
	  private String mobileNumber;
	  private int  totalLimit;
	  private int amountUsed;
	  private int amountAvailable;
	  
}
