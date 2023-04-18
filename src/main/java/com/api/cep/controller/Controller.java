package com.api.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.cep.model.Endereco;

@RestController
@RequestMapping(value = "/v1") 
public class Controller {
	
	@Autowired
	Endereco endereco;
	
	@PostMapping("/consulta-endereco")
	public Endereco endereco(@RequestBody Endereco endereco) {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Endereco> resp = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json", endereco.getCep()), Endereco.class);
		
		return resp.getBody();
	}

}
