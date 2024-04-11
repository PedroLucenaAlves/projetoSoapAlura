package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaWebService {

	public static void main(String[] args) {
		
		EstoqueWS service = new EstoqueWS(); //instancia da classe servico
		
		String url= "http://localhost:8080/estoquews"; //definindo url 
		
		System.out.println("Servico rodando " + url + "?wsdl");
		
		//publicando servico
		//endpoint = endereco concreto de um servico
		Endpoint.publish(url, service);
		

	}

}
