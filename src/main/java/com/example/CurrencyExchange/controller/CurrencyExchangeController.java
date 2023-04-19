package com.example.CurrencyExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.CurrencyExchange.beans.CurrencyExchange;
import com.example.CurrencyExchange.repository.CurrencyExchangeRepository;
@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	Environment env;
	
	@GetMapping(value="/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveCurrencyExchange(@PathVariable String from,@PathVariable String to) {
		
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		
		String port = env.getProperty("local.server.port");
		
		currencyExchange.setEnv(port);
	
		
		return currencyExchange;
		
		
		
	
	}
}
