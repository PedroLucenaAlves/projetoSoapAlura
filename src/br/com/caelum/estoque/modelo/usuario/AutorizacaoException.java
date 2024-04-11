package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.ws.WebFault;

import br.com.caelum.estoque.modelo.item.InfoFault;

@WebFault(name = "AutorizacaoFault") //APELIDO QUE APARECE NA TAG DETAIL NO SOAP INFORMANDO DE QUAL EXCEPTION SE TRATA
public class AutorizacaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String mensagem) {
		super(mensagem); // passando mensagem para classe mae
	}

	// Este trecho é exibido em <detail> na resposta do soap apos requisicao
	public InfoFault getFaultInfo() {
		return new InfoFault("Token Invalido " , new Date());
	}

}
