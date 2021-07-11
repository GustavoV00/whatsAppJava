package entities;

import java.util.ArrayList;
import java.util.*;

import creator.CGrupo;
import creator.CMensagem;
import interfaces.IUsuario;

public class Usuario implements IUsuario {
	private String nome;
	private String telefone;
	private String status;
	private String foto;
	private ArrayList<Grupo> grupos = new ArrayList<Grupo>();
	private ArrayList<Mensagem> mensagem = new ArrayList<Mensagem>();


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

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public ArrayList<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

	public ArrayList<Mensagem> getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(ArrayList<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public Grupo criarGrupo(String descricao, Usuario criadorDoGrupo) {
		CGrupo criadorCGrupo = new CGrupo();
		Grupo g = criadorCGrupo.criarGrupo(descricao);

		incluirUsuario(criadorDoGrupo, g);
		incluirAdm(criadorDoGrupo, g);
		return g;
	}

	@Override
	public void enviarMensagem(Grupo g, String str, TipoMensagem tipo, Usuario user){
		CMensagem criadorMensagen = new CMensagem();
		Mensagem msg = criadorMensagen.criarMensagem(user, tipo, str, new Date(), g.getDescricao());
		g.getMensagem().add(msg);
        user.getMensagem().add(msg);
	}

	@Override
	public void incluirUsuario(Usuario u, Grupo g) {
		u.getGrupos().add(g);
		g.getUsuarios().add(u);
	}

	@Override
	public void incluirAdm(Usuario u, Grupo g) {
		g.getArrayAdm().add(u);
	}

	@Override
	public void imprimirInformacoesUsuarios(Usuario u){
		System.out.println();
		System.out.println("Nome: " + u.nome);
		System.out.println("Telefone: " + u.telefone);
		System.out.println("Status: " + u.status);
		System.out.println("Foto: " + u.foto);

		int i = 0;
		// Imprime a descrição de cada grupo que o usuário pertence
		System.out.print("Grupos que o usario faz parte: ");
		System.out.print("{ ");
		for(Grupo grupo: u.grupos){
			System.out.print(u.nome + "-" + grupo.getDescricao() + ", ");
			i += 1;
		}
		System.out.println("}");

		i = 0;
		// Imprime todas as mensagens que vão ser enviadas aos grupos.
		System.out.print("Mensagens que o usário enviou: ");
		System.out.print("{ ");
		for(Mensagem msg: u.getMensagem()){
			System.out.print("\"" + msg.getCorpoMsg() + "'" + ", ");
			i += 1;
		}
		System.out.print("}");

		System.out.println("\n----------------------------------------------");
	}

}
