
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Faixa_De_Tempo_Com_ChronoUnit {

	public static void main(String[] args) throws ParseException{
		
		/*METODO ChronoUnit SERVE PARA CALCULÇAR A QUANTIDADE DE DIAS ENTRE DUAS DATAS */
		
	long dias = ChronoUnit.DAYS.between(LocalDate.parse("2020-12-01"), LocalDate.now());/*QUANTIDADE DE DIAS ENTRE AS DATAS*/
	
	System.out.println("Possui um Total de "+dias);
		
	System.out.println(LocalDate.now());
	
	String datad = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	
	System.out.println(datad);
		
	}
}
