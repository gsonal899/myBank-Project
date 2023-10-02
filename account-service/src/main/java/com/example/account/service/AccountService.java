package com.example.account.service;

import java.util.List;

import com.example.account.dto.APIResponseDto;
import com.example.account.dto.AccountDto;

public interface AccountService
{
	public List<AccountDto> fetchAllAccountDetails();
    public AccountDto fetchAccountDetailsByCustomerId(int customerId);
    
    public APIResponseDto fetchAccountAndCardDetailsByCustomerId(int customerId);
    public APIResponseDto fetchAccountCardAndBalanceDetailsByCustomerId(int customerId);
    
    public AccountDto create(AccountDto accountDto);
    
    public boolean updateAccount(int customerId,AccountDto accountDto);
    
    public boolean deleteAccount(int customerId);
}
 