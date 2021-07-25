package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import command.Command;
import command.EnviarMensagemCommand;
import command.IncluiUsuarioComumCommand;
import command.IncluirUsuarioAdmCommand;
import command.ExcluirMensagem;
import interfaces.IUsuario;

public class Usuario implements IUsuario  {
	private String nome;
	private String telefone;
	private String status;
	private String foto;
	private ArrayList<Grupo> grupos = new ArrayList<Grupo>();
	private ArrayList<Mensagem> mensagem = new ArrayList<Mensagem>();
	public static Map<String, Command> comandos = new HashMap<String, Command>();
	private Map<String, ArrayList<Mensagem>> mensagensGrupo = new HashMap<String, ArrayList<Mensagem>>();

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

	public Map<String,ArrayList<Mensagem>> getMensagensGrupo() {
		return this.mensagensGrupo;
	}

	public void setMensagensGrupo(Map<String,ArrayList<Mensagem>> mensagensGrupo) {
		this.mensagensGrupo = mensagensGrupo;
	}

	public static void nomeDoComando(String comando){
		comandos.get(comando).executarComando();
	}

	public static void gerarComandos(Usuario user, TipoMensagem tipo, String str, Grupo g, Usuario adm){
		comandos.put("Enviar Mensagem", new EnviarMensagemCommand(user, tipo, str, g));
		comandos.put("Incluir Usuario", new IncluiUsuarioComumCommand(user, adm, g));
		comandos.put("Incluir Usuario Adm", new IncluirUsuarioAdmCommand(adm, g));
		comandos.put("Excluir Mensagem", new ExcluirMensagem(user, g));
	}

	public void atualizarMensagem(String grupo, ArrayList<Mensagem> mensagens){
		mensagensGrupo.put(grupo, mensagens);
	}

//	@Override
//	public void incluirUsuario(Usuario u, Grupo g, Usuario adm) {
//		if(adm == g.getArrayAdm().get(0)) {
//			u.getGrupos().add(g);
//			g.getUsuarios().add(u);
//
//		}else
//			System.out.println("Usuario nao eh adiministrador");
//	}
//
//	@Override
//	public void incluirAdm(Usuario adm, Grupo g) {
//		g.getArrayAdm().add(adm);
//	}

	@Override
	public void imprimirInformacoesUsuarios(Usuario u, Map<String, ArrayList<Usuario>> usuarioVisualizou){
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
		System.out.print("}\n");

		// Imprime todas as mensagens que vão ser enviadas aos grupos.
		System.out.print("Mensagens atualizadas: ");

		i = 0;
		for(String grupo : u.mensagensGrupo.keySet()){
			System.out.print("{ ");
			System.out.print("\"" +  grupo +"\"");
			
			System.out.print(" : ");
	
			for(ArrayList<Mensagem> msg : u.mensagensGrupo.values()){
				for(Mensagem corpoMsg : msg){
					System.out.print("\"" + corpoMsg.getCorpoMsg() +"'" + ", ");
				}
			}
			System.out.println("}");
		}


		System.out.print("Povo que visualizou as mensagens: { ");
		for(String grupo : usuarioVisualizou.keySet()){
			System.out.print("{ ");
			System.out.print("\"" +  grupo +"\"");
			System.out.print(" : ");
			for(ArrayList<Usuario> user: usuarioVisualizou.values()){
				for(Usuario uu : user){
					System.out.print("\"" + uu.getNome() +"'" + ", ");
				}
			}
			System.out.println("}");
		}




		
		System.out.println("\n----------------------------------------------");
	}

}