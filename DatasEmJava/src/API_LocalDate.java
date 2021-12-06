import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class API_LocalDate {

	public static void main (String [] args) {
		
		LocalDate DataAtual = LocalDate.now();
		
		System.out.println("A Data Atual É: "+DataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		LocalTime HoraAtual = LocalTime.now();
		
		System.out.println("A Hora Atual É: "+HoraAtual.format(DateTimeFormatter.ofPattern("hh:mm.ss")));
		
		LocalDateTime DataEHoraAtual = LocalDateTime.now();
		
		System.out.println("A Data E Hora Atual É: "+DataEHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm.ss")));
		
	
	
									/*PEGANDO DIA, MÊS E ANO DE UMA DATA*/
		
		
	   LocalDate data = LocalDate.now();
	   
	   System.out.println("Data Atual "+ data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	   
	   
	   System.out.println("Dia Do Ano: "+data.getDayOfYear());
	   
	   System.out.println("Dia Da Mês: "+data.getDayOfMonth());
	   
	   System.out.println("Dia Da Semana: "+data.getDayOfWeek());
	   
	   
	   System.out.println("Ano: "+data.getYear());
	   
	   System.out.println("Mês: "+data.getMonth());
	   
	   System.out.println("Dia: "+data.getDayOfMonth());
	   
	   
	   
	   
	
	}
}
