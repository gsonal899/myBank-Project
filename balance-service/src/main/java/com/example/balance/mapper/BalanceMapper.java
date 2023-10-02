package com.example.balance.mapper;

import com.example.balance.dto.BalanceDto;
import com.example.balance.entity.Balance;

public class BalanceMapper 
{
   public static BalanceDto mapToBalanceDto(Balance balance)
   {
	   BalanceDto balanceDto=new BalanceDto(
			                     balance.getCustomerId(),
			                     balance.getAvailableBalance()); 
	   
	    return balanceDto;
	   
   }
}
