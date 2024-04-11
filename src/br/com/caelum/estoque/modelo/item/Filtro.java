package br.com.caelum.estoque.modelo.item;

/**
 * A classe Filtro define o tipo do item (celular, livro, etc) e o nome do item.
 * @author pedro.lucena
 *
 */

public class Filtro {

	private TipoItem tipo;

	private String nome;

	public TipoItem getTipo() {
		return tipo;
	}

	public void setTipo(TipoItem tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
