package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED) //definindo o estilo no SOAP
public class EstoqueWS { //RPC

	private ItemDao dao = new ItemDao();

	// Definindo o nome na tag <operation> no xml chamado no navegador
	@WebMethod(operationName = "todosOsItens")
	@ResponseWrapper(localName = "itens") // redefini o nome do elemento que embrulha a mensagem
	@WebResult(name = "itenm") // alterando o nome da tag retorno
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) { // @WebParam modifica o tipo do parametro(arg) que aparece no nosso Soap para realziar as requisicoes com os dados para busca
																			

		System.out.println("Chamando getItens");

		List<Filtro> lista = filtros.getLista();

		List<Item> result = dao.todosItens(lista);
		return new ListaItens(result);

	}

	@WebMethod(action="CadastrarItemAction" , operationName = "CadastrarItem")
	@WebResult(name = "item") // alterando o nome da tag retorno
	                                                           // cria um item e devolve para o banco de dados as infos do token ficaram na tag header do soap
	public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario tokenUsuario,
			@WebParam(name = "item") Item item) throws AutorizacaoException {

		System.out.println("Cadastrando item " + item + ", Token: " + tokenUsuario); //exibe os itens passados n o body e o token informado no header

		// validando toke
		if(! new TokenDao().ehValido(tokenUsuario)) { //validando se o token e valido
			
			System.out.println("validando Token");
			
            throw new AutorizacaoException("Autorizacao falhou");
        }

        //novo
        new ItemValidador(item).validate(); //fault uncheked

        this.dao.cadastrar(item);
        return item;
	}

}
