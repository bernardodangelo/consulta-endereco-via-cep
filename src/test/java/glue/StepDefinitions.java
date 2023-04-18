package glue;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.logging.Logger;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class StepDefinitions {
	private static final Logger logger = Logger.getLogger(StepDefinitions.class.getName());
	private int responseCode;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String frete;
	private JSONObject JSONResponse;

	@Dado("que o usuário inseriu um cep válido {string}")
	public void que_o_usuário_inseriu_um_cep_válido(String string) {
		this.cep = cep;
	}

	@Quando("o serviço é consultado utilizando o cep")
	public void o_serviço_é_consultado_utilizando_o_cep() throws IOException, ParseException {
		URL url = new URL(String.format("https://viacep.com.br/ws/%s/json/", cep));
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		responseCode = connection.getResponseCode();

		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			JSONParser parser = new JSONParser();
			JSONResponse = (JSONObject) parser.parse(content.toString());

			logger.info("API response: \n" + content);
		}
	}

	@Então("são retornados o cep, rua, complemento, bairro, cidade, estado e o frete")
	public void são_retornados_o_cep_rua_complemento_bairro_cidade_estado_e_o_frete() {
		Assert.assertNotNull(JSONResponse);
		Assert.assertEquals(cep, JSONResponse.get("cep"));
		Assert.assertNotNull(JSONResponse.get("logradouro"));
		Assert.assertNotNull(JSONResponse.get("complemento"));
		Assert.assertNotNull(JSONResponse.get("bairro"));
		Assert.assertNotNull(JSONResponse.get("localidade"));
		Assert.assertNotNull(JSONResponse.get("uf"));
		Assert.assertNotNull(JSONResponse.get("frete"));
	}
	
	@Então("a resposta deve ser um erro")
	public void a_resposta_deve_ser_um_erro() {
		Assert.assertTrue("O CEP informado não existe", JSONResponse.get("erro").equals(true));
	}

}
