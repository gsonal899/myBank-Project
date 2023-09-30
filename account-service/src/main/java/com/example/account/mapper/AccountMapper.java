package com.example.account.mapper;

import com.example.account.dto.AccountDto;
import com.example.account.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto)
	{
		Account account=new Account(
				   accountDto.getCustomerId(),
				   accountDto.getFirstName(),
				   accountDto.getLastName(),
				   accountDto.getAccountNo(),
				   accountDto.getEmail(),
				   accountDto.getMobileNo());
		return account;
		
	}
	
	public static AccountDto mapToAccountDto(Account account)
	{
		AccountDto accountDto=new AccountDto(
				   account.getCustomerId(),
				   account.getFirstName(),
				   account.getLastName(),
				   account.getAccountNo(),
				   account.getEmail(),
				   account.getMobileNo());
		return accountDto;
		
	}
}
