package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SimgleConnetion;
import model.Telefone;
import model.User;

public class UserDao {

	public Connection connection;

	public UserDao() {
		connection = SimgleConnetion.getConnection();
	}

	public void salvar(User usuario) {

		try {

			String sql = "insert into userposjava (nome, email) values(?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getLogin());
			statement.execute();
			connection.commit(); // Salva no banco

			System.out.println("Salvo com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public List<User> listar() {

		try {

			String sql = "SELECT * FROM userposjava";

			List<User> ListaUsuario = new ArrayList<User>();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
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

	public void Atualizar(User usuario) {

		try {

			String sql = "UPDATE userposjava SET nome = ?, email = ?  WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getLogin());
			statement.setInt(3, usuario.getId());
			statement.execute();
			connection.commit();

			System.out.println("Atualizado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
	
	public void Deletar(int id) {
		try {
			
			String sql = "DELETE FROM userposjava WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			statement.execute();
			connection.commit();
			
			System.out.println("Deletado com sucesso!");
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
	public List<User> ListaComTelefone(){
		
		try {
			String sql = "select nome, numero, email from telefoneuser as fone\r\n"
						+ "inner join userposjava as userp\r\n"
						+ "on fone.usuariopessoa = userp.id";
			List<User> Usuarios = new ArrayList<User>();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				User usuario = new User();
				Telefone telefone = new Telefone();
				
				usuario.setNome(rs.getString(1));
				telefone.setNumero(rs.getString(2));
				usuario.setLogin(rs.getString(3));
						
				usuario.setTelefone(telefone);
				
				Usuarios.add(usuario);
			}
			
			System.out.println("Consulta Feita Com Sucesso!");
			return Usuarios;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
		
		
		
	}
}
