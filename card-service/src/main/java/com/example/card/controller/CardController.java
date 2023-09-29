package com.example.card.controller;

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

import com.example.card.dto.CardDto;
import com.example.card.service.CardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/myBank")
public class CardController
{
	private CardService  cardService;
	
	@GetMapping("/")
	public String welcome()
	{
		return "Welcome to CardDetails-myBank";
	}
	
	@GetMapping("/fetch")
	public  ResponseEntity<List<CardDto>> fetchAllCardFromDB()
	{
		List<CardDto> cardDto =cardService.fetchAllCard();
		return ResponseEntity.status(HttpStatus.OK).body(cardDto);
	}
	
	@GetMapping("/fetch/{mobileNumber}")
    public ResponseEntity<List<CardDto>> fetchAllCardDetailsByMobileNumber(@PathVariable String mobileNumber)
    {
		List<CardDto> cardDto=cardService.fetchCardByMobileNumber(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(cardDto);
    	
    }
	
	@PostMapping("/createCard")
    public ResponseEntity<CardDto> createNewcard(@RequestBody CardDto obj)
    {
		CardDto cardDto=cardService.create(obj);
		return  ResponseEntity.status(HttpStatus.CREATED).body(cardDto);
    	
    }
	
	@PutMapping("/update/{cardNumber}")
    public ResponseEntity<String> updateCardByCardNumber(@PathVariable String cardNumber,@RequestBody CardDto obj)
    {
		//boolean b=cardService.updateCard(cardNumber, obj);
		
		  cardService.updateCard(cardNumber, obj);
		return ResponseEntity.status(HttpStatus.OK).body("Card With Card-Number "+cardNumber+" updated Successfully");
    	
    }
	
	@DeleteMapping("/delete/{cardNumber}")
    public ResponseEntity<String> deleteCardByCardNumber(@PathVariable String cardNumber)
    {
    	// boolean b=cardService.deleteCard(cardNumber);
		
		     cardService.deleteCard(cardNumber);
    	 return ResponseEntity.status(HttpStatus.OK).body("Card With Card-Number "+cardNumber+" deleted Successfully");
    }
    
}
