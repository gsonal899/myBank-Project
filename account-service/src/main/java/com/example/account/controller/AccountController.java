package com.example.account.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.account.dto.APIResponseDto;
import com.example.account.dto.AccountDto;
import com.example.account.service.AccountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/myBank")
@RestController
public class AccountController 
{
	private AccountService  accountService;
	
	@GetMapping("/")
	public String welcome()
	{
		return "Welcome to AccountDetails-myBank";
	}
	
	@GetMapping("/fetch")
	public  ResponseEntity<List<AccountDto>> fetchAllAccountDetailsFromDB()
	{
		List<AccountDto> accountDto =accountService.fetchAllAccountDetails();
		return ResponseEntity.status(HttpStatus.OK).body(accountDto);
	}
	
	@GetMapping("/fetch/{customerId}")
    public ResponseEntity<AccountDto> fetchAccountDetailsByCustomerId(@PathVariable int customerId)
    {
		AccountDto accountDto=accountService.fetchAccountDetailsByCustomerId(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(accountDto);
    	
    }
	
	@GetMapping("/fetch/account/{customerId}")
    public ResponseEntity<APIResponseDto> fetchAccountAndCardByCustomerId(@PathVariable int customerId)
    {
		APIResponseDto apiResponseDto=accountService.fetchAccountAndCardDetailsByCustomerId(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponseDto);
    	
    }
	
	@PostMapping("/createAccount")
    public ResponseEntity<AccountDto> createNewAccount(@RequestBody AccountDto obj)
    {
		AccountDto accountDto=accountService.create(obj);
		return  ResponseEntity.status(HttpStatus.CREATED).body(accountDto);
    	
    }
	
	@PutMapping("/update/{customerId}")
    public ResponseEntity<String> updateAccountByCustomerId(@PathVariable int customerId,@RequestBody AccountDto obj)
    {
		// boolean b=accountService.updateAccount(customerId, obj);
		
		   accountService.updateAccount(customerId, obj);
		return ResponseEntity.status(HttpStatus.OK).body("account With Customer-Id "+customerId+" updated Successfully");
    	
    }
	
	@DeleteMapping("/delete/{customerId}")
    public ResponseEntity<String> deleteAccountByCustomerId(@PathVariable int customerId)
    {
    	// boolean b=accountService.deleteAccount(customerId);
		   accountService.deleteAccount(customerId);
    	 return ResponseEntity.status(HttpStatus.OK).body("account With Customer-Id "+customerId+" deleted Successfully");
    }
}
