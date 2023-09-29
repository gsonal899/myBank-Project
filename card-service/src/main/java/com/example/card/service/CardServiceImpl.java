package com.example.card.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.card.dto.CardDto;
import com.example.card.entity.Card;
import com.example.card.exception.CardAlreadyExistsException;
import com.example.card.exception.CardNotFoundException;
import com.example.card.mapper.CardMapper;
import com.example.card.repository.CardRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CardServiceImpl implements CardService
{
    private CardRepository  cardRepository;
    
	@Override
	public List<CardDto> fetchAllCard()
	{
		List<Card> card=cardRepository.findAll();
		List<CardDto> cardDto=card.stream().map(CardMapper::mapToCardDto).collect(Collectors.toList());
		return cardDto;
	}

	@Override  //fetch All Cards
	public List<CardDto> fetchCardByMobileNumber(String mobileNumber)
	{
		List<Card> card=cardRepository.findAllCardByMobileNumber(mobileNumber);
		if(card.isEmpty())
		{
		  throw new CardNotFoundException("Card","Mobile-Number",mobileNumber);	
		}
		else
		{
		List<CardDto> cardDto=card.stream().map(CardMapper::mapToCardDto).collect(Collectors.toList());
		return cardDto;
		}
	}

	@Override
	public CardDto create(CardDto cardDto)
	{
		Card cardObj=CardMapper.mapToCard(cardDto);
		Card card=cardRepository.findCardByCardNumber(cardObj.getCardNumber());
		if(card!=null)
		{
		  throw new CardAlreadyExistsException("Card","Card-Number",cardObj.getCardNumber());		
		}
		else
		{
		cardRepository.save(cardObj);
		}
		return CardMapper.mapToCardDto(cardObj);
	}

	@Override
	public boolean updateCard(String cardNumber,CardDto obj)
	{
		
	 Card existingCard=cardRepository.findCardByCardNumber(cardNumber); 
	 if(existingCard==null)
		{
		  throw new CardNotFoundException("Card","Card-Number",cardNumber);	
		}
	 else
	 {
	   //existingCard.setCardId(obj.getCardId());
   	   existingCard.setCardType(obj.getCardType());
   	   existingCard.setCardNumber(obj.getCardNumber());
   	   existingCard.setMobileNumber(obj.getMobileNumber());
   	   existingCard.setTotalLimit(obj.getTotalLimit());
   	   existingCard.setAmountUsed(obj.getAmountUsed());
  	   existingCard.setAmountAvailable(obj.getAmountAvailable());
   	 
  	   cardRepository.save(existingCard);
	 }
		return true;
	}

	@Override
	public boolean deleteCard(String cardNumber) 
	{
		Card card=cardRepository.findCardByCardNumber(cardNumber);
		if(card==null)
		{
		  throw new CardNotFoundException("Card","Card-Number",cardNumber);	
		}
		else
		{
			Long id=card.getCardId();
			cardRepository.deleteById(id);
		}
		return true;
	}

}
