import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {

	private String Login;
	private String Senha;
	private String CPF;

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	@Override
	public String toString() {
		return "Usuario [Login=" + Login + ", Senha=" + Senha + ", CPF=" + CPF + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CPF, Login, Senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(CPF, other.CPF) && Objects.equals(Login, other.Login)
				&& Objects.equals(Senha, other.Senha);
	}

}
