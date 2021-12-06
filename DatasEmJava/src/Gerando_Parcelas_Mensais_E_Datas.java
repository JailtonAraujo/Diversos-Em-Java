import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Gerando_Parcelas_Mensais_E_Datas {

	
	public static void main (String [] args) throws ParseException {
		
		Date DataInicial = new SimpleDateFormat("dd/MM/yyyy").parse("06/12/2021");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DataInicial);
		
		for(int parcela = 1; parcela <= 12; parcela++) {
			
			calendar.add(Calendar.MONTH, 1);/*ADICIONANDO MAIS UM MÊS A CADA CICLO*/
			
			System.out.println("Parcela numero: "+ parcela + " vencimento é em: "+
			new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
		}
		
		
	}
}
