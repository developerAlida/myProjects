package com.techelevator.services;

import com.techelevator.model.CatPic;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestCatFactService implements CatFactService {

	private static final String API_URL = "https://cat-data.netlify.app/api/facts/random";
	private RestTemplate restTemplate = new RestTemplate();


	@Override
	public CatFact getFact() {
		CatFact fact = restTemplate.getForObject(API_URL, CatFact.class);
		return fact;

	}

}
