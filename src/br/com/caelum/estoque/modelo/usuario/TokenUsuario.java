package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class TokenUsuario {

	@XmlElement(required=true) //elimina os comentarios nos beans do soap que descrevem a informacao obrigatoria como "optional"
	private String token;
	
	@XmlJavaTypeAdapter(DateAdapter.class) // informando ao soap a conversao que deve ser realizada no atributo dataValidade com os requisitos que implantamos na classe passada
	@XmlElement(required=true)
	private Date dataValidade;
	
	//JAX-B precisa desse construtor
	TokenUsuario() {
	}

	public TokenUsuario(String token, Date dataValidade) {
		this.token = token;
		this.dataValidade = dataValidade;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenUsuario other = (TokenUsuario) obj;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TokenUsuario [token=" + token + ", dataValidade=" + dataValidade + "]";
	}
}
