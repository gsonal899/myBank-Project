package com.example.balance.entity;

import java.math.BigDecimal;

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
@Table(name="Balance")
public class Balance
{
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="CustomerId")
   private long customerId;
   
   @Column(name="Available_Balance")
   private BigDecimal availableBalance;
}
