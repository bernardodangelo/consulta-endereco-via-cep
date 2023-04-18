package com.api.tdd.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.tdd.service.EnderecoService;

@RunWith(SpringRunner.class)
public class ControllerTest {
	

	@Autowired
	EnderecoService enderecoService;
	
    @BeforeEach
    public void setUp() {
        enderecoService = new EnderecoService();
    }
	
	@Test
	public void enderecoFrete() {
		String cep = "29375000";
		String frete = enderecoService.freteCalculatorWithDatabase(cep);
		
		
		Assertions.assertEquals(frete, "7.85");
	}
	
	
}
