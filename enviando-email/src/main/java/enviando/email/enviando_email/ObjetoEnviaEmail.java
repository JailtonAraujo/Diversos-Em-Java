package enviando.email.enviando_email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {

	
	private String UserName = "projetosjava2022@gmail.com";
	private String PassWord = "Java2022";
	
	private String ListaDestinatario = "";
	private String NomeRemetente = "";
	private String AssuntoEmail = "";
	private String CorpoDoEmail = "";

	
	
	
	
	public ObjetoEnviaEmail(String ListaDestinatario, String NomeRemetente, String AssuntoEmail, String CorpoDoEmail) {
		this.ListaDestinatario = ListaDestinatario;
		this.NomeRemetente = NomeRemetente;
		this.AssuntoEmail = AssuntoEmail;
		this.CorpoDoEmail = CorpoDoEmail;
	}





	public void EnviarEmail() throws Exception {
		
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*");
    	properties.put("mail.smtp.auth", "true");/*Autorização*/
    	properties.put("mail.smtp.starttls", "true");/*Autenticação*/
    	properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor Gmail Google*/
    	properties.put("mail.smtp.port", "465");/*Porta Do Servidor*/
    	properties.put("mail.smtp.socketFactory.port", "465");/*Especifica a porta a ser utilizada pelo socket*/
    	properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Class Socket De Conexão SMTP*/
    	
    	Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
    		@Override
    		protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
    			// TODO Auto-generated method stub
    			return new javax.mail.PasswordAuthentication(UserName, PassWord);
    		}
    	
    	});
    	
    	Address [] toUser = InternetAddress.parse(ListaDestinatario);
    	
    	Message message = new MimeMessage(session);
    	message.setFrom(new InternetAddress(UserName, NomeRemetente));/*QUEM ESTA ENVIANDO*/
    	message.setRecipients(Message.RecipientType.TO, toUser);/*PARA QUEM ESTA ENVIANDO*/
    	message.setSubject(AssuntoEmail);/*ASSUNTO DO EMAIL*/
    	message.setText(CorpoDoEmail);/*CORPO DO EMAIL*/
    	
    	Transport.send(message);/*ENVIANDO EMAIL*/
	}

}