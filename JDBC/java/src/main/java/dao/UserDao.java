package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SimgleConnetion;
import model.User;

public class UserDao {

	public Connection connection;
	
	public UserDao() {
		connection = SimgleConnetion.getConnection();
	}
	
	
	public void salvar(User usuario) {
		
		try {
			
			String sql = "insert into userposjava (id, nome, email) values(?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, usuario.getId());
			statement.setString(2, usuario.getNome());
			statement.setString(3, usuario.getLogin());
			statement.execute();
			connection.commit(); // Salva no banco
			
			System.out.println("Salvo com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	public List<User> listar () {
		
		try {
			
			String sql = "SELECT * FROM userposjava";
			
			List<User> ListaUsuario = new ArrayList<User>();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				User usuario = new User();
				
				usuario.setId(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setLogin(rs.getString(3));
				
				ListaUsuario.add(usuario);
			}
			
			System.out.println("Consulta feita com sucesso!");
			
			return ListaUsuario;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	} 
}
