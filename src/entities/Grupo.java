package entities;

import java.util.ArrayList;
import java.util.Map;

import interfaces.IGrupo;
import interfaces.Observado;

public class Grupo implements IGrupo, Observado {
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
    public void atualizaQuemNaoVisualizou(Usuario user){
        for(Mensagem msg : this.getMensagem()){
            msg.getVisualizacaoMensagem().add(user);
        }
    }

	@Override
	public void notificaObservadores(Mensagem msg){
		for(Usuario user : this.usuarios){
            // Ta passando um array de mnsagens do grupo.
			user.atualizarMensagem(this.descricao, this.mensagens);
			msg.getVisualizacaoMensagem().add(user);
		}
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

	//Na mensagem há um ArrayList chamado visualizacaoMensagem, que contem todos usuário do grupo. Quando o usuário visuzaliza, ele é removido desse Array, indicando que ele vizualizou a mensagem
	@Override
	public void visualizar(Usuario user, Mensagem msg, Map<String, ArrayList<String>> usuarioVisualizou, ArrayList<String> visualizouAux){
		msg.getVisualizacaoMensagem().remove(user);
        visualizouAux.add(user.getNome());
        usuarioVisualizou.put(msg.getCorpoMsg(), visualizouAux);
	};

}
