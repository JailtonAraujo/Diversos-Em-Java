import java.time.Duration;
import java.time.Instant;

public class Tempo_De_Processo_Com_Instant {

	public static void main (String [] args) throws InterruptedException {
		
		Instant Inicio = Instant.now();
		
		Thread.sleep(2000);
		
		Instant Final = Instant.now();
		
		Duration Duracao = Duration.between(Inicio, Final);
		
		System.out.println("DURA플O EM NANO SECUNDOS: "+Duracao.toNanos());
		
		System.out.println("DURA플O EM NANO MINUTOS: "+Duracao.toMinutes());
		
		System.out.println("DURA플O EM MILISECUNDOS: "+Duracao.toMillis());
		
		System.out.println("DURA플O EM SECUNDOS: "+Duracao.toSeconds());
		
		
		
		
	}
}
