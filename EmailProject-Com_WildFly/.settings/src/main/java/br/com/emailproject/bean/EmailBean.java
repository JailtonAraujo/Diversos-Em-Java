package br.com.emailproject.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.emailproject.dto.EmailLayout;
import br.com.emailproject.model.Email;
import br.com.emailproject.services.EmailService;

@Named
@RequestScoped
public class EmailBean implements Serializable{

	private static final long serialVersionUID = 4538755582654584073L;
	
	private static final String destinatario = "Jailton@gmail.com";
	private static final String Assunto = "Testando envio";
	
	@Inject
	private EmailService Emailservice;
	
	public String EnviarEmail() {
		Emailservice.Enviar(MontarEmail());
		
		return null;
	}
	
	private Email MontarEmail() {
		EmailLayout layout = new EmailLayout();
		
		return layout.MontarEmail(destinatario, Assunto);
	}
	

}
