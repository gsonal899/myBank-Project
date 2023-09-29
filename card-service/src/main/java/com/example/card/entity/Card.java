package com.example.card.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Cards")
public class Card
{ 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CardId")
	  private long cardId;
	
	@Column(name="Card_Number")
	  private String cardNumber;
	
	@Column(name="Card_Type")
	  private String cardType;
	
	@Column(name="Mobile_Number")
	  private String mobileNumber;
	
	@Column(name="Total_limit")
	  private int  totalLimit;
	
	@Column(name="Amount_Used")
	  private int amountUsed;
	
	@Column(name="Amount_Available")
	  private int amountAvailable;
	
	
}
