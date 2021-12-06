package Fila_Pilha_De_Execucao_Com_Thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjectFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjectFilaThread>();

	public static void add(ObjectFilaThread objetofilathread) {

		pilha_fila.add(objetofilathread);
	}

	@Override
	public void run() {

		System.out.println("FILA RODANDO...");

		while (true) {

			synchronized (pilha_fila) { /* BLOQUEAR O ACESSO A ESSA LISTA POR OUTROS PROCESSOS */

				Iterator iterator = pilha_fila.iterator();
				while (iterator.hasNext()) { // *ENQUANTO CONTER DADOS NA LISTA IRÁ PROCESSAR*//

					ObjectFilaThread processar = (ObjectFilaThread) iterator.next();/* PEGA O OBJETO ATUAL */

					// #EXEMPLOS DE PROCESSAMENTOS#//
					// PRCESSAR 10 MIL NOTAS FISCAIS
					/* GERAR UM GRANDE LISTA DE PDF */
					/* GERAR UM ENVIO EM MASSA DE EMAILS */

					System.out.println("======================================");

					System.out.println(processar.getNome());
					System.out.println(processar.getEmail());

					iterator.remove();

					try {
						Thread.sleep(100);/* DAR UM TEMPO PARA DESCARGA DE MEMORIA */
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

			try {
				Thread.sleep(100);/* PROCESSOU TODA LISTA DA UM TEMPO PARA LIMPEZA DE MEMORIA */
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
