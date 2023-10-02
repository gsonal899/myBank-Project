package com.example.balance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.balance.dto.BalanceDto;
import com.example.balance.service.BalanceService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/myBank")
public class BalanceController
{
   private BalanceService balanceService;
   
   @GetMapping("/")
	public String welcome()
	{
		return "Welcome to BalanceDetails-myBank";
	}
   
   @GetMapping("/checkBalance/{customerId}")
   public ResponseEntity<BalanceDto> fetchBalanceByCustomerId(@PathVariable Long customerId)
   {
		BalanceDto balanceDto=balanceService.fetchBalance(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(balanceDto);
   	
   }
}
