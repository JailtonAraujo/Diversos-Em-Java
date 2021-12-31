package br.com.emailproject.dto;

import br.com.emailproject.model.Email;

public class EmailLayout {

	private static final String QUEBRA_DE_LINHA_DUPLA = "<br><br>";
	
	public Email MontarEmail(String Destinatario, String Assunto) {
		StringBuilder text = new StringBuilder();
		
		text
			.append("A/C ADMINISTRADOR")
			.append(QUEBRA_DE_LINHA_DUPLA);
			
		text
			.append("ESTE EMAIL EMAIL ESTA SENDO ENVIADO ATRAVEZ DE JAVA")
			.append(QUEBRA_DE_LINHA_DUPLA)
			.append(false);
		
		GerarRodape(text);
		
		
		return new Email(Destinatario, Assunto, text.toString());
	}
	
	private String GerarRodape(StringBuilder texto) {
		
		return texto.append("email automatico por favor não responda a esse email").toString();
	}
}
