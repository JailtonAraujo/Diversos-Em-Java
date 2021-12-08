import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class API_LocalDate {

	public static void main (String [] args) {
		
		LocalDate DataAtual = LocalDate.now();
		
		System.out.println("A Data Atual �: "+DataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		LocalTime HoraAtual = LocalTime.now();
		
		System.out.println("A Hora Atual �: "+HoraAtual.format(DateTimeFormatter.ofPattern("hh:mm.ss")));
		
		LocalDateTime DataEHoraAtual = LocalDateTime.now();
		
		System.out.println("A Data E Hora Atual �: "+DataEHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm.ss")));
		
	
	
									/*PEGANDO DIA, M�S E ANO DE UMA DATA*/
		
		
	   LocalDate data = LocalDate.now();
	   
	   System.out.println("Data Atual "+ data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	   
	   
	   System.out.println("Dia Do Ano: "+data.getDayOfYear());
	   
	   System.out.println("Dia Da M�s: "+data.getDayOfMonth());
	   
	   System.out.println("Dia Da Semana: "+data.getDayOfWeek());
	   
	   
	   System.out.println("Ano: "+data.getYear());
	   
	   System.out.println("M�s: "+data.getMonth());
	   
	   System.out.println("Dia: "+data.getDayOfMonth());
	   
	   
	   										/*Faixa de tempo com Objeto Period*/
	   
	   LocalDate DataAntiga = LocalDate.of(2020, 05, 10);
	   
	   LocalDate DataNova = LocalDate.now();
	   
	   System.out.println("Data Antiga � Posterior que a Data Nova: " + DataAntiga.isAfter(DataNova));
	   
	   System.out.println("Data Antiga � Anterior que a Data Nova: " + DataAntiga.isBefore(DataNova));
	   
	   System.out.println("As Data s�o Iguais:" + DataAntiga.isEqual(DataNova));
	   
	   Period periodo = Period.between(DataAntiga, DataNova);
	   
	   System.out.println("Dias: "+periodo.getDays());
	   System.out.println("Meses: "+periodo.getMonths());
	   System.out.println("Anos: "+periodo.getYears());
	   
	   System.out.println("Periodo Total: "+ periodo.getDays()+" Dias "+periodo.getMonths()+" Meses "+periodo.getYears()+" Anos");
	   
	   
	   
	   
	   
	   
	
	}
}
