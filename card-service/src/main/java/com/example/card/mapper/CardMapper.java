package com.example.card.mapper;

import com.example.card.dto.CardDto;
import com.example.card.entity.Card;

public class CardMapper 
{
   public static Card mapToCard(CardDto cardDto)
   {
	   Card card=new Card(
			   cardDto.getCardId(),
			   cardDto.getCardNumber(),
			   cardDto.getCardType(),
			   cardDto.getMobileNumber(),
			   cardDto.getTotalLimit(),
			   cardDto.getAmountUsed(),
			   cardDto.getAmountAvailable()
	          );
	return card;
	   
   }
   
   public static CardDto mapToCardDto(Card card)
   {
	   CardDto cardDto=new CardDto(
			   card.getCardId(),
			   card.getCardNumber(),
			   card.getCardType(),
			   card.getMobileNumber(),
			   card.getTotalLimit(),
			   card.getAmountUsed(),
			   card.getAmountAvailable()
			   );
	return cardDto;
	   
   }
}
