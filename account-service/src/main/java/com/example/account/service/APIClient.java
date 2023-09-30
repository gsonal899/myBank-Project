package com.example.account.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.account.dto.CardDto;

@FeignClient(url="http://localhost:8083",value="CARD-SERVICE")
public interface APIClient
{
	@GetMapping("/myBank/fetch/{mobileNumber}")
    public List<CardDto> fetchAllCardDetailsByMobileNumber(@PathVariable String mobileNumber);
}
