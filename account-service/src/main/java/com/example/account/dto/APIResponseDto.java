package com.example.account.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class APIResponseDto
 {
  private AccountDto accountDto;
  private CardDto[] cardDto;
  private BalanceDto balanceDto;
}
