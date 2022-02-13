package model;

public class Telefone {
	private int Id;
	private String Numero;
	private String Tipo;
	private int UsuarioPessoa;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public int getUsuarioPessoa() {
		return UsuarioPessoa;
	}

	public void setUsuarioPessoa(int usuarioPessoa) {
		UsuarioPessoa = usuarioPessoa;
	}

	@Override
	public String toString() {
		return "Telefone [Id=" + Id + ", Numero=" + Numero + ", Tipo=" + Tipo + ", UsuarioPessoa=" + UsuarioPessoa
				+ "]";
	}
	
	

}
