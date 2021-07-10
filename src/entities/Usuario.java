package entities;

public class Usuario {
	private String nome;
	private String telefone;
	private String status;
	private String foto;

	public Usuario(String nome, String telefone, String status, String foto) {
		this.nome = nome;
		this.telefone = telefone;
		this.status = status;
		this.foto = foto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
