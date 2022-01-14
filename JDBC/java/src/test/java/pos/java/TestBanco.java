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
			System.out.println("===============================");
		}
		
		
	}
	
	@Test
	public void Atualizar() {
		
		UserDao dao = new UserDao();
		
		User usuario = new User();
		
		usuario.setId(2);
		usuario.setNome("Mario farias");
		usuario.setLogin("Mario@gmail.com");
		
		dao.Atualizar(usuario);
	}
	
	@Test
	public void Deletar() {
		UserDao dao = new UserDao();
		
		dao.Deletar(4);
	}
	
	
	@Test
	public void ConsultaInnerJoin() {
		
		UserDao dao = new UserDao();
		
		List<User> Usuarios = dao.ListaComTelefone();
		
		
		for (User user : Usuarios) {
			System.out.println(user);
			System.out.println("================");
			
		}
	}
	
	
	@Test
	public void qualquer() {
		
		User usuario = new User();
		
		usuario.getTelefone().setNumero("5465465454");
		
		System.out.println(usuario);
	}
	
}
