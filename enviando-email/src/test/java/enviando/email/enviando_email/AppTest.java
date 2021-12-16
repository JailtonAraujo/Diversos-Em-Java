package enviando.email.enviando_email;

import java.time.Duration;
import java.time.Instant;

import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest 
{
	
	
	@Test
    public void TesteMail() throws Exception{
    	
		Instant inicio = Instant.now();
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder(); 
		stringBuilderTextoEmail.append("Ola,<br/><br/>");
		stringBuilderTextoEmail.append("Você esta recebendo um email com html.<br/><br/>");
		stringBuilderTextoEmail.append("Segue abaixo para informações. <br/><br/>");
		
		stringBuilderTextoEmail.append("<br/><br/><a target=\"_blank\" href=\"https://www.amazon.com.br/Html-CSS-guia-pr%C3%A1tico-visual/dp/8576088037\" "
				+ " style=\"color: #000000; padding: 14px 25px; text-aligh: center; border-radius: 30px; text-decoration: none; display-inline: block; "
				+ " font-family: courier; border: 3px solid green; font-weight: bolder;\"> ACESSAR</a> <br/><br/>");
		
    	ObjetoEnviaEmail objetoEnviaEmail = new ObjetoEnviaEmail("jailtoncapoeira2017@gmail.com", "Jailton Araujo", "Testanto Classe", stringBuilderTextoEmail.toString());
    	
    	//objetoEnviaEmail.EnviarEmail(true);
    	
    	objetoEnviaEmail.EnviarEmailListaDeAnexo(true);
    	
    	/*CASO EMAIL NÃO ESTEJA SENDO ENVIADO COLOQUE UM TEMPO DE ESPERA, MAS ISSO SO PODE SER FEITO EM TESTE*/
    	
    	Thread.sleep(5000);// PAUSA DE 5 SEGUNDOS*/
    	
    	Instant Final = Instant.now();
    	
    	Duration duracao = Duration.between(inicio, Final);
    	
    	long dura = duracao.toSeconds();
    	
    	System.out.println("EMAIL ENVIADO COM SUCESSO");
    	System.out.println("TEMPO TOTAL DE ENVIO DOS EAMILS: "+dura);
    	
    	
    	
    	
    	
		
		
		/*OLHE AS CONFIGURAÇÃO DO SMTP DO EMAIL*/
    }
}
