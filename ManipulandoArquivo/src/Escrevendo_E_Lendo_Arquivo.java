import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escrevendo_E_Lendo_Arquivo {

	public static void main(String [] args) throws IOException {
		
		/*
		File arquivo = new File("C:\\Users\\jailt\\Documents\\GitHub\\MeusProjetos\\Diversos-Em-Java\\ManipulandoArquivo\\src\\arquivo\\arquivo.txt"); 
		
		  if(!arquivo.exists()) {
			  arquivo.createNewFile();
		  }
		  
		  FileWriter writer = new FileWriter(arquivo);
		  
		  writer.write("Testanto");
		  writer.flush();
		  writer.close();
		  */
		
		//Escrever();
		
		Ler();
		
	}
	
	public static void Ler() throws FileNotFoundException {
		
		FileInputStream ArquivoLeitura = new FileInputStream(new File("C:\\Users\\jailt\\Documents\\GitHub\\MeusProjetos\\Diversos-Em-Java\\ManipulandoArquivo\\src\\arquivo\\arquivo.txt"));
		
		Scanner Out = new Scanner(ArquivoLeitura, "UTF-8");
		
		while(Out.hasNext()) {
			String linha = Out.nextLine();
			
			if(linha != null && !linha.isEmpty()) {
				
				System.out.println(linha);
			}
		}
	}
	
	
	
		/*GRAVANDO OBJETOS PESSOAS DO ARQUIVO */
	public static void Escrever() throws IOException {
		File arquivo = new File("C:\\Users\\jailt\\Documents\\GitHub\\MeusProjetos\\Diversos-Em-Java\\ManipulandoArquivo\\src\\arquivo\\arquivo.txt"); 
		
		  if(!arquivo.exists()) {
			  arquivo.createNewFile();
		  }
		  
		  FileWriter writer = new FileWriter(arquivo);
		
		  Pessoa p1 = new Pessoa("Jailton","jailton@gamirl.com", 23);
		  Pessoa p2 = new Pessoa("Carlor", "carlos@gail.comn", 26);
		  Pessoa p3 = new Pessoa("Diogo", "diogo@gmail.com", 30);
		  
		  
		  List<Pessoa> ListaPessoa = new ArrayList<Pessoa>();
		  
		  ListaPessoa.add(p1);
		  ListaPessoa.add(p2);
		  ListaPessoa.add(p3);
		  
		  
		  for(Pessoa p : ListaPessoa) {
			  writer.write(p.getNome()+";"+p.getEmail()+";"+p.getIdade()+"\n");
		  }
		  writer.flush();
		  writer.close();
		  
	}
	
}
