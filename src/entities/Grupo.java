package entities;

import java.util.ArrayList;

import interfaces.IGrupo;

public class Grupo implements IGrupo {
	private String descricao;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Mensagem> mensagem = new ArrayList<Mensagem>();

	public Grupo(String descricao, ArrayList<Usuario> usuarios, ArrayList<Mensagem> mensagem) {
		this.descricao = descricao;
		this.usuarios = usuarios;
		this.mensagem = mensagem;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Mensagem> getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(ArrayList<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public void imprimirInformacoesGrupo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirMensagem() {
		// TODO Auto-generated method stub
		
	}
}
