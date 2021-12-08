
public class Pessoa {

	private String Nome;
	private String Email;
	private int idade;

	
	public Pessoa() {}
	
	
	
	public Pessoa(String nome, String email, int idade) {
		super();
		Nome = nome;
		Email = email;
		this.idade = idade;
	}



	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}



	@Override
	public String toString() {
		return "Pessoa [Nome=" + Nome + ", Email=" + Email + ", idade=" + idade + "]";
	}
	
	

}
