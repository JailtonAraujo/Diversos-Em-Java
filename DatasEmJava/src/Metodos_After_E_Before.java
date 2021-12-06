import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Metodos_After_E_Before {

public static void main(String [] args) throws ParseException {
		
		/*TRABALHANDO COM DATAS*/
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Date DataVencimento = format.parse("03/12/2021");
		
		Date DataHoje = format.parse("03/12/2021");
		
		if(DataVencimento.after(DataHoje)) {  /*SE A DATA DO VENCIMENTO POSTERIOR/MAIOR QUE A DATA ATUAL*/
			System.out.println("Boleto Não Vencido");
		}
		else if(DataVencimento.before(DataHoje)) { /*SE A DATA DO VENCIMENTO FOR ANTERIOR/MENOR QUE A DATA ATUAL*/
			System.out.println("Boleto Vencido!");
			
		}else {
			System.out.println("boleto não vencido"); /*CASO NUNHUMA DAS CONDIÇÕES ACIMA ACONTEÇA AS DATAS SERÃO IGUAIS*/
		}
	}
	
}
