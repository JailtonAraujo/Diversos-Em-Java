package enviando.email.enviando_email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.imageio.stream.ImageInputStream;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.xml.simpleparser.NewLineHandler;

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




				/*METDODO PARA ENVIAR EMAIL NORMAL*/

	public void EnviarEmail(boolean EnvioHtmal) throws Exception {
		
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
    	
    	
    	if (EnvioHtmal) {
    		message.setContent(CorpoDoEmail, "text/html; charset=utf-8");
    	}else {
    		message.setText(CorpoDoEmail);/*CORPO DO EMAIL*/
    	}
    	
    	Transport.send(message);/*ENVIANDO EMAIL*/
	}
	
	/*ESSE METODO SIMULA O PDF OU QUALQUER ARQUIVO QUE POSSA SER ENVIADO POR ANEXO NO EMAIL.*/
	/*VOCÊ PODE PEGAR O ARQUIVO NO SEU BANCO DE DADOS BASE64, BYTE[], STREAM DE ARQUIVOS.*/
	/*PODE ESTAR EM UM BANCO OU UMA PASTA*/
	private FileInputStream simuladordePdf() throws Exception {
		Document document = new Document();
		File file = new File("Anexo.pdf");
		file.createNewFile();/*CRIANDO ARQUIVO EM TEMPO DE EXECUÇÃO*/
		PdfWriter.getInstance(document, new FileOutputStream(file));/*ESCREVENDO O CONTEUDO DO FILE DENTRO DO DOCUMENTO PDF*/
		
		document.open();
		document.add(new Paragraph("Testando envio de pdf"));
		document.close();
		
		return new FileInputStream(file); /*RETORNANDO UM PDF EM BRANCO COM O TEXTO DO PARAGRAFO*/
		
	}
	
	
		/*METODO PARA ENVIAR EMAIL COM ANEXO*/
public void EnviarEmailAnexo(boolean EnvioHtmal) throws Exception {
		
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
    	
    	/*PARTE 1 DO EMAIL QUE É O TEXTO EA DESCRIÇÃO DO EAMIL*/
    	
    	MimeBodyPart CorpoEmail = new MimeBodyPart();
    	
    	
    	if (EnvioHtmal) {
    		CorpoEmail.setContent(CorpoDoEmail, "text/html; charset=utf-8");
    	}else {
    		CorpoEmail.setText(CorpoDoEmail);/*CORPO DO EMAIL*/
    	}
    	
    	/*PARTE 2 DO EMAIL QUE OS ANEXOS*/
    	MimeBodyPart AnexoDoEmail = new MimeBodyPart();
    	AnexoDoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(simuladordePdf(), "application/pdf")));/*ADICIONANDO O CONTEUDO DO ANEXO E TIPO DO ARQUIVO*/
    	AnexoDoEmail.setFileName("AnexoTest.pdf");
    	
    	Multipart multipart = new MimeMultipart();/*OBJETO QUE IRÁ JUNTAR AS PARTES DO EMAIL*/
        multipart.addBodyPart(CorpoEmail);/*ADICIONANDO CORPO DO EMAIL*/
        multipart.addBodyPart(AnexoDoEmail);/*ADICIONANDO ANEXO DO EMAIL*/
        
        message.setContent(multipart);
    	
    	Transport.send(message);/*ENVIANDO EMAIL*/
	}

}