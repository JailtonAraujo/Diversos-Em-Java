package pos.java;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.UserDao;
import model.User;

public class TestBanco {
	
	@Test
	public void salvar() {
		
		UserDao dao = new UserDao();
		
		User usuario = new User ();
		
		usuario.setId(3);
		usuario.setNome("hugo");
		usuario.setLogin("hugo@gmail.com");
		
		dao.salvar(usuario);
		
	}
	
	@Test
	public void listar() {
		
		UserDao dao = new UserDao();
		
		List<User> Usuarios = new ArrayList<User>();
		
		Usuarios = dao.listar();
		
		for (User user : Usuarios) {
			System.out.println(user);
		}
		
		
	}
}
