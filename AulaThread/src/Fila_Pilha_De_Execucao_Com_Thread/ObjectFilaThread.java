package Fila_Pilha_De_Execucao_Com_Thread;

import java.util.Objects;

public class ObjectFilaThread {

	private String Nome;
	private String Email;

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

	@Override
	public String toString() {
		return "ObjectFilaThread [Nome=" + Nome + ", Email=" + Email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Email, Nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectFilaThread other = (ObjectFilaThread) obj;
		return Objects.equals(Email, other.Email) && Objects.equals(Nome, other.Nome);
	}

}
