package br.com.caelum.estoque.modelo.usuario;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Classe criada para realizar adaptações no formato das datas no SOAP
 * @author pedro.lucena
 *
 */



public class DateAdapter extends XmlAdapter<String, Date> {
	
	private String pattern= "dd/MM/yyyy";
	
	
	public Date unmarshal(String dateString) throws Exception{
		
		System.out.println("unmarhshal: " + dateString);
		
		return new SimpleDateFormat(pattern).parse(dateString);
	}
	
	
	//ensinando o JAX-B a converter um Date em uma String do tipo dd/MM/yyyy (marshal)
	public String marshal(Date date) throws Exception {
		   return new SimpleDateFormat(pattern).format(date);
		}

	

}
