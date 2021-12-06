package ThreadTime;
import javax.swing.JOptionPane;

public class PrimeiraThread {

	public static void main(String[] args) throws InterruptedException {
/*
		new Thread() {
			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					System.out.println(i);
				}
			}
		}.start();
		
		System.out.println("Sucesso!");

	}
	
*/	
Thread trd = new Thread(thread1);
trd.start();
		
JOptionPane.showMessageDialog(null, "Ola você!");
	}
	
	
private static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				System.out.println(i);
			}
			// TODO Auto-generated method stub
			
		}
	};

}

