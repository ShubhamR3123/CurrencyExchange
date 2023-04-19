package com.example.CurrencyExchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CurrencyExchange.beans.CurrencyExchange;

public interface CurrencyExchangeRepository  extends JpaRepository<CurrencyExchange,Long>{
	
	public CurrencyExchange findByFromAndTo(String from,String to);

}
