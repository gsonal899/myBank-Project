package com.example.balance.service;

import com.example.balance.dto.BalanceDto;

public interface BalanceService 
{
     public BalanceDto fetchBalance(Long customerId);
}
