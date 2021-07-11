package entities;

import java.util.ArrayList;

import interfaces.IGrupo;

public class Grupo implements IGrupo {
	private String descricao;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Mensagem> mensagem = new ArrayList<Mensagem>();
	private ArrayList<Usuario>  arrayAdm = new ArrayList<Usuario>();

	public Grupo (String descricao) {
		this.descricao = descricao;
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

	public ArrayList<Usuario> getArrayAdm() {
		return this.arrayAdm;
	}

	public void setArrayAdm(ArrayList<Usuario> arrayAdm) {
		this.arrayAdm = arrayAdm;
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
