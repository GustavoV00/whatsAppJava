package entities;

import java.util.ArrayList;

import interfaces.IGrupo;

public class Grupo implements IGrupo {
	private String descricao;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
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
		return this.mensagens;
	}

	public void setMensagem(ArrayList<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public ArrayList<Usuario> getArrayAdm() {
		return this.arrayAdm;
	}

	public void setArrayAdm(ArrayList<Usuario> arrayAdm) {
		this.arrayAdm = arrayAdm;
	}

	@Override
	public void imprimirInformacoesGrupo(Grupo g) {
		System.out.println("Grupo: " + g.getDescricao());
		int indice = 0;
			for(Usuario user : g.getUsuarios()){
				System.out.println("Usuario: " + user.getNome()+ " - " + indice);
				indice += 1;
			}
	
			// Apesar de em nossa implementação ter apenas um adm por grupo, se no futuro houver mais de um, será impresso todos
			System.out.println("\nAdministrador do grupo: " + g.getDescricao());
			for(Usuario user : g.getArrayAdm()){
				System.out.println(user.getNome());
			}
	
			System.out.println("\nMensagens do grupo: ");
			int i = 0;
			for(Mensagem msg: g.mensagens){
				System.out.print(i + "-");
				System.out.print("Autor da mensagem: " +  msg.getAutor().getNome() + ", ");
				System.out.print("Tipo da mensagem: " + msg.getTipoMsg() + ", ");
				System.out.print("Mensagem a ser enviada: " + msg.getCorpoMsg() + ", ");
				System.out.print("Data de envio: " + msg.getDataEnvio() + " ");
				System.out.print("Grupo que a mensagem pertence: " + msg.getMensagemGrupo() + " \n");
				i += 1;
			}
	
			System.out.println();
	}

	@Override
	public void excluirMensagem(Usuario u, Grupo g) {
		// Criar uma instância, de uma mensagem que tem na lista de usuários
		Mensagem msgAux = u.getMensagem().get(0);
		// Percorre todas as mensagens, que o usuario enviou em todos os grupos
		// E encontra a ultima mensagem, que o usuario enviou ao grupo. 
		for(Mensagem msg: u.getMensagem()){
			if(msg.getMensagemGrupo() == g.getDescricao()){
				msgAux = msg;
				
			} 
		}

		// Após encontrar a mensagem, faz uma verificação final, se a mensagem
		// está no grupo certo. Após isso, exclui a mensagem, tanto do grupo,
		// quanto das mensagens enviadas pelo usuario.
		if(msgAux.getMensagemGrupo() == g.getDescricao()){
			g.getMensagem().remove(msgAux);
			u.getMensagem().remove(msgAux);

			System.out.println("MENSAGEM QUE FOI EXCLUIDA: " + msgAux.getCorpoMsg());
			System.out.println("Usuario que enviou a mensagem: " + u.getNome());
			System.out.println("Grupo que o usuário enviou a mensagem: "+ g.getDescricao());
			System.out.println();
		}
	}
}
