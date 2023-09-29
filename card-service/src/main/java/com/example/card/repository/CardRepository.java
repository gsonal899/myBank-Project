package com.example.card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.card.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Long>
{
  
	public List<Card> findAllCardByMobileNumber(String mobileNumber);
	
	public Card findCardByCardNumber(String cardNumber);
}
