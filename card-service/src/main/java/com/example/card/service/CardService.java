package com.example.card.service;

import java.util.List;

import com.example.card.dto.CardDto;

public interface CardService
 {
    public List<CardDto> fetchAllCard();
    public List<CardDto> fetchCardByMobileNumber(String mobileNumber);
    
    public CardDto create(CardDto cardDto);
    
    public boolean updateCard(String cardNumber,CardDto cardDto);
    
    public boolean deleteCard(String cardNumber);
}
