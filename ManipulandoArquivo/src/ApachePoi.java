import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		File arquivo_xls = new File("C:\\Users\\jailt\\Documents\\GitHub\\MeusProjetos\\Diversos-Em-Java\\ManipulandoArquivo\\src\\arquivo\\arquivo_xls.xls");
		
		if(!arquivo_xls.exists()) {
			arquivo_xls.createNewFile();
		}
		

		  Pessoa p1 = new Pessoa("Jailton","jailton@gamirl.com", 23);
		  Pessoa p2 = new Pessoa("Carlor", "carlos@gail.comn", 26);
		  Pessoa p3 = new Pessoa("Diogo", "diogo@gmail.com", 30);
		  
		  
		  List<Pessoa> ListaPessoa = new ArrayList<Pessoa>();
		  
		  ListaPessoa.add(p1);
		  ListaPessoa.add(p2);
		  ListaPessoa.add(p3);
		  
		  HSSFWorkbook hssWorkbook = new HSSFWorkbook();/*SERA USADO PARA ESCREVER A PLANILHA*/
		  
		  
		  
	}
}
