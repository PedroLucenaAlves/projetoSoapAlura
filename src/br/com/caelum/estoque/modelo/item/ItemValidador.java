package br.com.caelum.estoque.modelo.item;

import java.util.ArrayList;
import java.util.List;

public class ItemValidador {

	private Item item;

	public ItemValidador(Item item) {
		this.item = item;
	}

	//ao chamarmos o servico, ele realiza todas as validacoes 
	public void validate() {
		List<String> erros = new ArrayList<>();
		
		System.out.println("Realizando validacoes passadas se sao existentes no nosso banco");
		
		String codigo = item.getCodigo();
		if(ehVazio(codigo) || codigo.length() != 3){
			erros.add("Codigo invalido");
		}

		String nome = item.getNome();
		if(ehVazio(nome) || nome.length() < 3){
			erros.add("Nome invalido");
		}
		
		int quantidade = item.getQuantidade();
		if(quantidade <= 0){
			erros.add("Quantidade invalida");
		}
		
		String tipo = item.getTipo();
		if(ehVazio(tipo) || !TipoItem.existe(tipo)) {
			erros.add("Tipo invalido");
		}
		
		if(!erros.isEmpty()){
//			throw new RuntimeException("argg"); 

			throw new ItemValidadorException(erros); 
		}
	}

	private boolean ehVazio(String valor) {
		
		System.out.println("Verificando se o conteudo e nulo ou esta vazio");
		
		return valor == null || valor.isEmpty();
	}

}
