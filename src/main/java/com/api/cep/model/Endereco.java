package com.api.cep.model;

import org.springframework.stereotype.Component;

import com.api.cep.model.Endereco;

@Component
public class Endereco {
	
	private String cep;
	private String rua;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String localidade;
	private String estado;
	private String uf;
	private String frete;
	
	  public String getCep() {
	        return cep;
	    }

	    public void setCep(String cep) {
	        this.cep = cep;
	    }

	    public String getRua() {
	        return logradouro;
	    }

	    public void setRua(String rua) {
	    }

	    public String getComplemento() {
	        return complemento;
	    }

	    public void setComplemento(String complemento) {
	        this.complemento = complemento;
	    }

	    public String getBairro() {
	        return bairro;
	    }

	    public void setBairro(String bairro) {
	        this.bairro = bairro;
	    }

	    public String getCidade() {
	        return localidade;
	    }

	    public void setCidade(String cidade) {
	    }

	    public String getEstado() {
	        return uf;
	    }

	    public void setEstado(String estado) {
	    }

	    public String getFrete() {
	        return frete;
	    }

	    private void calcularFrete() {
	        switch(uf) {
	            case "SP":
	            case "RJ":
	            case "MG":
	            case "ES":
	                frete = "7.85";
	                break;
	            case "MT":
	            case "MS":
	            case "GO":
	            case "DF":
	                frete = "12.50";
	                break;
	            case "AC":
	            case "AM":
	            case "AP":
	            case "PA":
	            case "RO":
	            case "RR":
	            case "TO":
	                frete = "20.83";
	                break;
	            case "AL":
	            case "BA":
	            case "CE":
	            case "MA":
	            case "PB":
	            case "PE":
	            case "PI":
	            case "RN":
	            case "SE":
	                frete = "15.98";
	                break;
	            case "PR":
	            case "RS":
	            case "SC":
	                frete = "17.30";
	                break;
	            default:
	                frete = "0";
	        }
	    }

	    public void setLogradouro(String logradouro) {
	        this.logradouro = logradouro;
	    }

	    public void setLocalidade(String localidade) {
	        this.localidade = localidade;
	    }

	    public void setUf(String uf) {
	        this.uf = uf;
	        calcularFrete();
	    }

	}
