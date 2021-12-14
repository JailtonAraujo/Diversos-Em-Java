package enviando.email.enviando_email;

import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest 
{
	
	
	@Test
    public void TesteMail() throws Exception{
    	
    	ObjetoEnviaEmail objetoEnviaEmail = new ObjetoEnviaEmail("jailtoncapoeira2017@gmail.com", "Jailton Araujo", "Testanto Classe", "Java é a melhor linguegem de programação");
    	
    	objetoEnviaEmail.EnviarEmail();
    	
    	/*CASO EMAIL NÃO ESTEJA SENDO ENVIADO COLOQUE UM TEMPO DE ESPERA, MAS ISSO SO PODE SER FEITO EM TESTE*/
    	
    	Thread.sleep(5000);// PAUSA DE 5 SEGUNDOS*/
    	
    	
    	System.out.println("EMAIL ENVIADO COM SUCESSO");
    	
    	
    	
    	
    	
		
		
		/*OLHE AS CONFIGURAÇÃO DO SMTP DO EMAIL*/
    }
}
