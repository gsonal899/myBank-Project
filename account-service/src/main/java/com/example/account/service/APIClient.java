package com.example.account.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.account.dto.BalanceDto;
import com.example.account.dto.CardDto;

//@FeignClient(url="http://localhost:8083,http://localhost:8085",value="CARD-SERVICE,BALANCE-SERVICE")
//@FeignClient(url="http://localhost:8085",value="BALANCE-SERVICE")
public interface APIClient
{
	@GetMapping("/myBank/fetch/{mobileNumber}")
    public List<CardDto> fetchAllCardDetailsByMobileNumber(@PathVariable String mobileNumber);
	
	
	@GetMapping("/myBank/checkBalance/{customerId}")
    public BalanceDto fetchBalanceByCustomerId(@PathVariable Long customerId);
}
