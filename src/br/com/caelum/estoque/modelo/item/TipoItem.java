package br.com.caelum.estoque.modelo.item;

import javax.xml.bind.annotation.XmlEnumValue;

public enum TipoItem {

	@XmlEnumValue("Livro")
	LIVRO("Livro"), 
	@XmlEnumValue("Celular")
	CELULAR("Celular"),
	@XmlEnumValue("Tablet")
	TABLET("Tablet");
	
	private String nome;

	TipoItem(String nome) { 
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static boolean existe(String valor) {
		
		System.out.println("Verificando Enums para saber se os itens existem");
		
		try{
			//joga IllegalArgumentException caso nao exista
			TipoItem.valueOf(valor.toUpperCase());
		}catch(IllegalArgumentException e) {
			System.err.println("Item inexistente" + e.getMessage());
			return false;
		}
		return true;
	}
}
