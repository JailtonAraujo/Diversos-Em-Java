import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Escrevendo_JSON_em_arquivo_TXT_com_GSON {

	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		
		usuario1.setCPF("456454456");
		usuario1.setLogin("usuâriô1");
		usuario1.setSenha("123");
		
		Usuario usuario2 = new Usuario();
		
		usuario2.setCPF("5465454");
		usuario2.setLogin("usuário2");
		usuario2.setSenha("456");
		
		List<Usuario> ListaUsuario = new ArrayList<Usuario>();
		
		ListaUsuario.add(usuario1); 
		ListaUsuario.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String JsonUser = gson.toJson(ListaUsuario); /*PASSANDO LISTA DE USUARIOS PARA JSON*/
		
		
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\jailt\\Documents\\GitHub\\MeusProjetos\\Diversos-Em-Java\\ManipulandoArquivo\\src\\arquivo\\filjson.json"); /*GRAVANDO ARQUIVO*/
		
		fileWriter.write(JsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		System.out.println(JsonUser);
		
		
		
		
		
		/*=======================================================**LENDO O JSO**N=======================================================================*/
		
		
		
		FileReader reader = new FileReader("C:\\Users\\jailt\\Documents\\GitHub\\MeusProjetos\\Diversos-Em-Java\\ManipulandoArquivo\\src\\arquivo\\filjson.json");/*LENDO O ARQUIVO JSON*/
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(reader);/*CRIANDO UM ARRAY DE ELEMENTOS/OBJETOS DO ARQUIVO JSON "CADA ELEMENTO DESSE É DELIMITADO POR {}, E TUDO CONTIDO NELAS SERA CONVERTIDO EM ATIBUTOS DE OBJETOS"*/	
		
		List<Usuario> ListUsuario = new  ArrayList<Usuario>();/*ARRAY DE USUARIOS QUE RECEBERÁ TODOS OS OBJETOS DESSE TIPO CONTIDOS NO ARQUIVO JSON*/
		
		 for (JsonElement jsonElement : jsonArray) { /*PERCORRENDO O JsonArray*/
			
			 Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);/*CONVERTENDO O JsonElement ATUAL PARA OBJETO DO TIPO USUARIO E JA PASSANDO PARA O usuario QUE FOI INSTANCIADO*/
			 
			 ListUsuario.add(usuario);/*ADICIONANDO O USUARIO CONVERTIDO A UMA LISTA DE USUARIOS*/
		}
		 
		 System.out.println("LEITURA DO ARQUIVO JSON: "+ListUsuario);/*IMPRIMINADO LISTAS*/
		
		
		
		
		
		
	}
}
