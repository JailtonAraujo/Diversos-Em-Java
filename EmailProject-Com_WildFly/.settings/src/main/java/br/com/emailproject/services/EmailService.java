package br.com.emailproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import br.com.emailproject.model.Email;
import br.com.emailproject.util.LogUtil;

@Stateless
public class EmailService extends Thread {

	public static final String HEADER_CONTEXT = "text/html; charset=utf-8";
	
	private List<Email> Emails;

	public void Enviar(Email email) {
		Emails = new ArrayList<>();
		Emails.add(email);
		Send();
	}

	public void Enviar(List<Email> Emails) {
		this.Emails = Emails;
		Send();
	}

	private EmailService Copia() {
		EmailService emailservice = new EmailService();
		emailservice.Emails = Emails;

		return emailservice;
	}

	private void Send() {
		new Thread(this.Copia()).start();
		;
	}

	@Override
	public void run() {
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", System.getProperty("email-project.mail.smtp.host"));
		props.put("mail.smtp.port", System.getProperty("email-project.mail.smtp.port"));

		Session session = Session.getInstance(props);
		session.setDebug(false);

		for (Email email : Emails) {

			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(System.getProperty("email-project.mail.from")));
				
				if(email.getDestinatario().contains("/")) {
					List<InternetAddress> emailslocal = new ArrayList<>();
					
					for(String e : email.getDestinatario().split("/")) {
						emailslocal.add(new InternetAddress(e));
					}
					
					message.addRecipients(Message.RecipientType.TO, emailslocal.toArray(new InternetAddress[0]));
				}else {
					InternetAddress para = new InternetAddress(email.getDestinatario());
					message.addRecipient(Message.RecipientType.TO, para);
				}
				
				message.setSubject(email.getAssunt());
				
				MimeBodyPart textpart = new MimeBodyPart();
				
				textpart.setHeader("Content-type",HEADER_CONTEXT);
				textpart.setContent(email.getText(), HEADER_CONTEXT);
				
				Multipart mp = new MimeMultipart();
				
				mp.addBodyPart(textpart);
				
				message.setContent(mp);
				
				Transport.send(message);
				
				
			} catch (MessagingException ex) {
				LogUtil.getlogger(EmailService.class).error("Erro ao Enviar Email: " + ex.getMessage());
			}

		}

	}
}
