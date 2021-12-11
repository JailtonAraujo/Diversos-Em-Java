import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Apache_Poi_Editando {

	
	public static void main(String[] args) throws Exception {
		File arquivo = new File("C:\\Users\\jailt\\Documents\\GitHub\\MeusProjetos\\Diversos-Em-Java\\ManipulandoArquivo\\src\\arquivo\\arquivo_xls.xls");
		
		FileInputStream Entrada = new FileInputStream(arquivo);
		
		HSSFWorkbook hssWorkbook = new HSSFWorkbook(Entrada);/*PREPARA A ENTRADA DO aqruivo.xls EXCEL*/
		
		HSSFSheet planilha = hssWorkbook.getSheetAt(0);/*PEGANDO A PLANILHA*/
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) { /*PERCORRE TODAS AS LINHAS*/
			
			Row linha = linhaIterator.next();/*DADOS DA PESSOA NA LINHA*/
			
			int NumeroCelulass = linha.getPhysicalNumberOfCells();/*QUANTIDADE DE CELULAS*/
			
			String ValorDaCelular = linha.getCell(0).getStringCellValue();
			
			linha.getCell(0).setCellValue(ValorDaCelular + "Editado");
			
			Cell celula = linha.createCell(NumeroCelulass);/*CRIANDO NOVA CELULA*/
			celula.setCellValue("5.210");
			
		}
		
		Entrada.close();
		
		FileOutputStream saida = new FileOutputStream(arquivo);
		hssWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada");
				
	}
}
	

