import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lendo_Arquivo_E_Transformando_Em_ArrayList {
	
	
	public static void main (String[] args) throws FileNotFoundException {
		
		LerArray();
	}
	
	
	public static void LerArray() throws FileNotFoundException {
		
		FileInputStream EntradaArquivo = new FileInputStream(new File("C:\\Users\\jailt\\Documents\\GitHub\\MeusProjetos\\Diversos-Em-Java\\ManipulandoArquivo\\src\\arquivo\\arquivo.txt"));
		
		Scanner LerArquivo = new Scanner(EntradaArquivo, "UTF-8");
		
		List<Pessoa> ListaPessoa = new ArrayList<Pessoa>();
		
		while(LerArquivo.hasNext()) {
			
			String linha = LerArquivo.nextLine();
			
			if(linha!= null && !linha.isEmpty()) {
				
				String [] dados = linha.split("\\;");
				
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				
				
				ListaPessoa.add(pessoa);
			}
			
		}
		
		for (Pessoa pessoa : ListaPessoa) {
			
			System.out.println(pessoa);
		}
	}
}
