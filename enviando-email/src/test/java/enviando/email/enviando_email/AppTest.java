package enviando.email.enviando_email;

import static org.junit.Assert.assertTrue;

import java.net.Authenticator;
import java.net.InterfaceAddress;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest 
{
	private String UserName = "projetosjava2022@gmail.com";
	private String PassWord = "Java2022";
	
	@Test
    public void TesteMail() {
    	try {
		
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
    	
    	Address [] toUser = InternetAddress.parse("jailtonraneimoney@gmail.com, jailtoncapoeira2017@gmail.com, natanaelima2120@gmail.com");
    	
    	Message message = new MimeMessage(session);
    	message.setFrom(new InternetAddress(UserName,"Jailton Santos"));/*QUEM ESTA ENVIANDO*/
    	message.setRecipients(Message.RecipientType.TO, toUser);/*PARA QUEM ESTA ENVIANDO*/
    	message.setSubject("ENVIANDO EMAIL COM JAVAXMAIL");/*ASSUNTO DO EMAIL*/
    	message.setText("Olá Dev Você acaba de receber um email enviado com java mail");/*CORPO DO EMAIL*/
    	
    	Transport.send(message);/*ENVIANDO EMAIL*/
    	
    	
    	/*CASO EMAIL NÃO ESTEJA SENDO ENVIADO COLOQUE UM INTERVALO ENTRE OS ENVIOS, MAS ISSO SO PODE SER FEITO EM TESTE*/
    	
    	/*Thread.Sleep(5000); PAUSA DE 5 SEGUNDOS*/
    	
    	
    	System.out.println("EMAIL ENVIADO COM SUCESSO");
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	
		
		
		/*OLHE AS CONFIGURAÇÃO DO SMTP DO EMAIL*/
    }
}
