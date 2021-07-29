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
import interfaces.Observador;

public class Usuario implements IUsuario, Observador  {
	private String nome;
	private String telefone;
	private String status;
	private String foto;
	private ArrayList<Grupo> grupos = new ArrayList<Grupo>();
	private ArrayList<Mensagem> mensagem = new ArrayList<Mensagem>();
	public Map<String, Command> comandos = new HashMap<String, Command>();
	private Map<String, ArrayList<Mensagem>> mensagensGrupo = new HashMap<String, ArrayList<Mensagem>>();
	public ArrayList<Mensagem> mensagensExcluidas = new ArrayList<Mensagem>();

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

	public void nomeDoComando(String comando){
		comandos.get(comando).executarComando();
	}

	public void gerarComandos(TipoMensagem tipo, String str, Grupo g, Usuario adm){
		comandos.put("Enviar Mensagem", new EnviarMensagemCommand(this, tipo, str, g));
		comandos.put("Incluir Usuario", new IncluiUsuarioComumCommand(this, adm, g));
		comandos.put("Incluir Usuario Adm", new IncluirUsuarioAdmCommand(adm, g));
		comandos.put("Excluir Mensagem", new ExcluirMensagem(this, g));
	}

	public ArrayList<Mensagem> removeDuplicatas(ArrayList<Mensagem> mensagens){
		int quantidade;
		ArrayList<Mensagem> mensagensReturn = new ArrayList<Mensagem>();
		for(Mensagem msg : mensagensExcluidas){
			quantidade = 0;
			for(Mensagem msg2 : mensagens) {
				mensagensReturn.add(msg2);
				if(msg2.getCorpoMsg() == msg.getCorpoMsg() && quantidade == 0){
					quantidade += 1;

				} else if(msg2.getCorpoMsg() == msg.getCorpoMsg() && quantidade > 0){
					quantidade += 1;
					mensagensReturn.remove(msg2);
				}
			}
			if(quantidade == 1) mensagensReturn.remove(msg);
		}
		return mensagensReturn;
	}

	public void atualizarMensagem(String grupo, ArrayList<Mensagem> mensagens){
		if(mensagensExcluidas.size() == 0 )
			mensagensGrupo.put(grupo, mensagens);
		else {
			mensagens = removeDuplicatas(mensagens);
			mensagensGrupo.put(grupo, mensagens);
		}
	}

	@Override
	public void imprimirInformacoesUsuarios(Usuario u, Map<String, ArrayList<String>> usuarioVisualizou){
		System.out.println();
		System.out.println("Nome: " + u.nome);
		System.out.println("Telefone: " + u.telefone);
		System.out.println("Status: " + u.status);
		System.out.println("Foto: " + u.foto);

		// Imprime a descrição de cada grupo que o usuário pertence
		System.out.print("Grupos que o usario faz parte: ");
		System.out.print("{ ");
		for(Grupo grupo: u.grupos){
			System.out.print(u.nome + "-" + grupo.getDescricao() + ", ");
		}
		System.out.println("}");

		// Imprime todas as mensagens que vão ser enviadas aos grupos.
		System.out.print("Mensagens que o usário enviou: ");
		System.out.print("{ ");
		for(Mensagem msg: u.getMensagem()){
			System.out.print("\"" + msg.getCorpoMsg() + "'" + ", ");
		}
		System.out.print("}\n");

		// Imprime todas as mensagens que vão ser enviadas aos grupos.
		System.out.print("Mensagens atualizadas: \n");
		u.mensagensGrupo.forEach((key, value) -> { Usuario.imprimeMensagensAtualizadas(key, value); });

		System.out.println();

		System.out.print("Povo que visualizou as mensagens: \n");
		usuarioVisualizou.forEach((key, value) -> { imprimeMensagensVisualizadas(key, value); });

		System.out.println("\n----------------------------------------------");
	}

	public static void imprimeMensagensAtualizadas(String key, ArrayList<Mensagem> value){
		System.out.println(key + " : " + value);
	}
	
	public static void imprimeMensagensVisualizadas(String msg, ArrayList<String> user){
		System.out.println(msg + " : " + user);
	}

}
