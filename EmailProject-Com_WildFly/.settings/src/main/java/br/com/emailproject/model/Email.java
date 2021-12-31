package br.com.emailproject.model;

public class Email {
	private String Destinatario;
	private String Assunt;
	private String Text;

	
	public Email(String destinatario, String assunt, String text) {
		Destinatario = destinatario;
		Assunt = assunt;
		Text = text;
	}

	public String getDestinatario() {
		return Destinatario;
	}

	public void setDestinatario(String destinatario) {
		Destinatario = destinatario;
	}

	public String getAssunt() {
		return Assunt;
	}

	public void setAssunt(String assunt) {
		Assunt = assunt;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {																					
		Text = text;
	}

}
