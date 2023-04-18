package com.cucumber.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/feature/bradesco.Cucumber.feature", // caminho para o arquivo .feature
	    glue = "glue", // nome do pacote onde estão as classes de definição de passos
	    plugin = { "pretty", "json:target/cucumber-reports/cucumber.json" } // formato de saída dos resultados
	)
	public class CEPCucumberTest {
	}

