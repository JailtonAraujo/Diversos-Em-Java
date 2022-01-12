package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SimgleConnetion {

	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection conncetion = null;

	static {
		Conectar();
	}

	private SimgleConnetion() {
		Conectar();
	}

	private static void Conectar() {
		try {
			
			if(conncetion == null) {
				Class.forName("org.postgresql.Driver");
				conncetion = DriverManager.getConnection(url, user, password);
				conncetion.setAutoCommit(false);
				System.out.println("Conexão Bem Sucedida!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
	}
	

	public static Connection getConnection() {
		
		return conncetion;
	}
}