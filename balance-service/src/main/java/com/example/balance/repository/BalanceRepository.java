package com.example.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.balance.entity.Balance;

public interface BalanceRepository extends JpaRepository<Balance,Long>
{

}
