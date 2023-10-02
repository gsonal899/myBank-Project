package com.example.balance.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.balance.dto.BalanceDto;
import com.example.balance.entity.Balance;
import com.example.balance.exception.CustomerIdNotPresentException;
import com.example.balance.mapper.BalanceMapper;
import com.example.balance.repository.BalanceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BalanceServiceImpl implements BalanceService 
{
	private BalanceRepository balanceRepository;

	@Override
	public BalanceDto fetchBalance(Long customerId)
	{ 
		Optional<Balance> obj=balanceRepository.findById(customerId);
		if(!obj.isPresent())
		{
			throw  new CustomerIdNotPresentException("Customer","Customer-Id",customerId);
		}
		else
		{
		return BalanceMapper.mapToBalanceDto(obj.get());
		}
	}

}
