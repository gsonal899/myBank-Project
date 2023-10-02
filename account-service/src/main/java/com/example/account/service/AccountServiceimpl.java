package com.example.account.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.account.dto.APIResponseDto;
import com.example.account.dto.AccountDto;
import com.example.account.dto.BalanceDto;
import com.example.account.dto.CardDto;
import com.example.account.entity.Account;
import com.example.account.exception.AccountAlreadyExistsException;
import com.example.account.exception.AccountNotFoundException;
import com.example.account.mapper.AccountMapper;
import com.example.account.repository.AccountRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceimpl implements AccountService
{
	private AccountRepository  accountRepository;
	
	private WebClient webClient;
	//  private APIClient apiClient;
	
	@Override
	public List<AccountDto> fetchAllAccountDetails()
	{
		List<Account> account=accountRepository.findAll();
		List<AccountDto> accountDto=account.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
		
	    return accountDto;		
	}

	@Override
	public AccountDto fetchAccountDetailsByCustomerId(int customerId)
	{
        Account account=accountRepository.findAccountByCustomerId(customerId);
        if(account==null)
        {
        	throw new AccountNotFoundException("Account","Customer-Id",customerId);
        }
        else
        {
        AccountDto accountDto=AccountMapper.mapToAccountDto(account);
		return accountDto;
        }
	}
	
	public APIResponseDto fetchAccountAndCardDetailsByCustomerId(int customerId)
	{
        Account account=accountRepository.findAccountByCustomerId(customerId);
        if(account==null)
        {
        	throw new AccountNotFoundException("Account","Customer-Id",customerId);
        }
        else
        {
        	
        AccountDto accountDto=AccountMapper.mapToAccountDto(account);
        
        CardDto[] cardDto=webClient.get()
                 .uri("http://localhost:8083/myBank/fetch/"+accountDto.getMobileNo())
                 .retrieve()
                 .bodyToMono(CardDto[].class)
                 .block();
        
      //  List<CardDto> cardDto=apiClient.fetchAllCardDetailsByMobileNumber(accountDto.getMobileNo());
        
        
        APIResponseDto apiResponseDto=new APIResponseDto();
         apiResponseDto.setAccountDto(accountDto);
         apiResponseDto.setCardDto(cardDto);
        
		return apiResponseDto;
        }
	}
	@Override
	public APIResponseDto fetchAccountCardAndBalanceDetailsByCustomerId(int customerId)
	{
		Account account=accountRepository.findAccountByCustomerId(customerId);
        if(account==null)
        {
        	throw new AccountNotFoundException("Account","Customer-Id",customerId);
        }
        else
        {
        	
        AccountDto accountDto=AccountMapper.mapToAccountDto(account);
        
        CardDto[] cardDto=webClient.get()
                 .uri("http://localhost:8083/myBank/fetch/"+accountDto.getMobileNo())
                 .retrieve()
                 .bodyToMono(CardDto[].class)
                 .block();
        
       BalanceDto balanceDto=webClient.get()
                .uri("http://localhost:8085/myBank/checkBalance/"+accountDto.getCustomerId())
                .retrieve()
                .bodyToMono(BalanceDto.class)
                .block();
       
       //  List<CardDto> cardDto=apiClient.fetchAllCardDetailsByMobileNumber(accountDto.getMobileNo());
       //  BalanceDto balanceDto=apiClient.fetchBalanceByCustomerId(accountDto.getCustomerId());
         
         
         APIResponseDto apiResponseDto=new APIResponseDto(accountDto,cardDto,balanceDto);
          // apiResponseDto.setAccountDto(accountDto);
         // apiResponseDto.setCardDto(cardDto);
         // apiResponseDto.setbalanceDto(balanceDto);
         
         
 		return apiResponseDto;
        }
		
	}
	@Override
	public AccountDto create(AccountDto obj)
	{
		Account accountObj=AccountMapper.mapToAccount(obj);
		Account account=accountRepository.findAccountByAccountNo(accountObj.getAccountNo());
		if(account!=null)
		{
		  throw new AccountAlreadyExistsException("Account","Account-Number",accountObj.getAccountNo());		
		}
		else
		{
		accountRepository.save(accountObj);
		}
		return AccountMapper.mapToAccountDto(accountObj);
	}

	@Override
	public boolean updateAccount(int customerId, AccountDto obj)
	{
		Account existingAccount=accountRepository.findAccountByCustomerId(customerId); 
		 if(existingAccount==null)
			{
			  throw new AccountNotFoundException("Account","Customer-Id",customerId);	
			}
		 else
		 {
		// existingAccount.setCustomerId(obj.getCustomerId());
	   	 existingAccount.setFirstName(obj.getFirstName());
	   	 existingAccount.setLastName(obj.getLastName());
	   	 existingAccount.setAccountNo(obj.getAccountNo());
	   	 existingAccount.setEmail(obj.getEmail());
	  	 existingAccount.setMobileNo(obj.getMobileNo());
	  	 
	  	  accountRepository.save(existingAccount);
		 }
	  	  return true;
	}

	@Override
	public boolean deleteAccount(int customerId)
	{
		Account account=accountRepository.findAccountByCustomerId(customerId);
		if(account==null)
		{
		  throw new AccountNotFoundException("Account","Customer-Id",customerId);	
		}
		else
		{
			int id=account.getCustomerId();
			accountRepository.deleteById(id);
		}
		return true;
	}

	

}
