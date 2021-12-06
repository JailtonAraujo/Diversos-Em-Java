import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class API_LocalDate {

	public static void main (String [] args) {
		
		LocalDate DataAtual = LocalDate.now();
		
		System.out.println("A Data Atual �: "+DataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		LocalTime HoraAtual = LocalTime.now();
		
		System.out.println("A Hora Atual �: "+HoraAtual.format(DateTimeFormatter.ofPattern("hh:mm.ss")));
		
		LocalDateTime DataEHoraAtual = LocalDateTime.now();
		
		System.out.println("A Data E Hora Atual �: "+DataEHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm.ss")));
		
	}
}
