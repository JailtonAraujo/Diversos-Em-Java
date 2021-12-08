import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data_anos_dias_meses_e_parcelas_com_LocalDate {

	public static void main(String[] args) {
		
		LocalDate data = LocalDate.parse("2021-08-07");
		
			/*ATRIBUINDO DIAS, MESES, ANOS E SEMANAS A UMA DATA*/
		
		System.out.println("Mais 5 Dias: "+(data = data.plusDays(5)) );
		
		System.out.println("Mais 5 Semanas: "+(data= data.plusWeeks(5)) );
		
		System.out.println("Mais 5 Anos: "+(data= data.plusYears(5)) );
		
		System.out.println("Mais 5 Meses: "+(data =data.plusMonths(5)) );
		
		
		

			/*ATRIBUINDO DIAS, MESES, ANOS E SEMANAS A UMA DATA*/
		
		System.out.println("Menos 5 Dias: "+(data =data.minusDays(5)) );
		
		System.out.println("Menos 5 Semanas: "+(data= data.minusWeeks(5)) );
		
		System.out.println("Menos 5 Anos: "+(data= data.minusYears(5)) );
		
		System.out.println("Menos 5 Meses: "+(data =data.minusMonths(5)) );
		
		
					/*CALCULANDO VENCIMENTO*/
		System.out.println("\n\n");
		
		
		
		LocalDate dataHoje = LocalDate.now();
		
		for(int mes = 1; mes <= 12; mes++) {
			dataHoje = dataHoje.plusMonths(1);
			
			System.out.println("DATA DO VENCIMENTOS DO BOLETO: "+dataHoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " Mês: "+mes);
			
		}
		
	}
}
