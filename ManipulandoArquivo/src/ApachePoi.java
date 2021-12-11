import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		Gravar();  
		
		Ler();
		  
		  
		  
		  
	}
	
	
	public static void Ler() throws IOException {
		
		FileInputStream Entrada = new FileInputStream(new File("C:\\Users\\jailt\\Documents\\GitHub\\MeusProjetos\\Diversos-Em-Java\\ManipulandoArquivo\\src\\arquivo\\arquivo_xls.xls"));
		
		HSSFWorkbook hssWorkbook = new HSSFWorkbook(Entrada);/*PREPERA A ENTRADA DO ARQUIVO EXCEL PARA LER*/
		HSSFSheet Planilha = hssWorkbook.getSheetAt(0);/*PEGA A PRIMEIRA LINHA DO ARQUIVO*/
		
		Iterator<Row> LinhaIterador = Planilha.iterator();/*RECEBERAR A ITERAÇÃO DE TODAS AS LINHAS DA PLANILHA*/
		
		List<Pessoa> ListaPessoa = new ArrayList<Pessoa>();
		
		while(LinhaIterador.hasNext()) { /*IRA PERCORRER TODA PLANILHA ENQUATO TIVER LINHAS NO ARQUIVO EXCEL*/
			
			Row Linha = LinhaIterador.next();/*PEGANDO LINHA DA PLANILHA E DADOS DA PESSOA NA LINHA*/
			
			Iterator<Cell> Celulas = Linha.iterator();/*PEGANDO E CRIANDO CELULAS DOS DADOS DA LINHA*/
			
			Pessoa pessoa = new Pessoa();
			
			while(Celulas.hasNext()) { /*PERCORENDO AS CELULAS DA LINHA*/
				
				Cell CelulaAtua = Celulas.next(); /*RECEBENDO A CELULA ATUAL*/
				
				switch(CelulaAtua.getColumnIndex()) { /*VERIFICANDO O INDICE DA CELULA E ATRIBUINDO AO ATRIBUTO DE PESSOA CORRESPONDENTE*/
				case 0:
					pessoa.setNome(CelulaAtua.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(CelulaAtua.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(CelulaAtua.getNumericCellValue()).intValue());
					break;
				}
				
			}/*FIM DAS CELULAS*/
			
			ListaPessoa.add(pessoa); /*ADICIONANDO A PESSOA JA COM OS DADOS PREENCHIDOS A LISTA*/
			
		}
		
		Entrada.close();
		
		for(Pessoa p : ListaPessoa) {
			System.out.println(p);
		}
		
		
	}
	
	
	
	public static void Gravar() throws IOException {
		
File arquivo_xls = new File("C:\\Users\\jailt\\Documents\\GitHub\\MeusProjetos\\Diversos-Em-Java\\ManipulandoArquivo\\src\\arquivo\\arquivo_xls.xls");
		
		if(!arquivo_xls.exists()) {
			arquivo_xls.createNewFile();
		}
		

		  Pessoa p1 = new Pessoa("Jailton","jailton@gamirl.com", 23);
		  Pessoa p2 = new Pessoa("Carlor", "carlos@gail.comn", 26);
		  Pessoa p3 = new Pessoa("Diogo", "diogo@gmail.com", 30);
		  Pessoa p4 = new Pessoa("Flavio", "Flavio@Gmail.com", 32);
		  
		  
		  List<Pessoa> ListaPessoa = new ArrayList<Pessoa>();
		  
		  ListaPessoa.add(p1);
		  ListaPessoa.add(p2);
		  ListaPessoa.add(p3);
		  ListaPessoa.add(p4);
		  
		  HSSFWorkbook hssWorkbook = new HSSFWorkbook();/*SERA USADO PARA ESCREVER A PLANILHA*/
		  HSSFSheet LinhasPessoa = hssWorkbook.createSheet("Planilha de Pessoas");/*CRIANDO PLANILHA*/
		  
		  int NumeroLinha = 0;
		  
		  for(Pessoa p : ListaPessoa) {
			  Row linha = LinhasPessoa.createRow(NumeroLinha++);/*CRIANDO A LINHA DA PLANILHA*/
			  
			  int celula = 0;
			  
			  Cell CelNome = linha.createCell(celula++);/*CELULA 01*/
			  CelNome.setCellValue(p.getNome());
			  

			  Cell CelEmail = linha.createCell(celula++);/*CELULA 02*/
			  CelEmail.setCellValue(p.getEmail());
			  

			  Cell CelIdade = linha.createCell(celula++);/*CELULA 03*/
			  CelIdade.setCellValue(p.getIdade());
			  
		  } /*TERMINANDO DE MONTAR PLANILHA*/
		  
		  FileOutputStream saida = new FileOutputStream(arquivo_xls);
		  hssWorkbook.write(saida);/*ESCREVE A PLANILHA EM ARQUIVO*/
		  
		  saida.flush();
		  saida.close();
		  
		  System.out.println("PLANILHA CRIADA!");
		  
		
	}
}
