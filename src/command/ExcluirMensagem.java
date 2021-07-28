package command;

import entities.*;

public class ExcluirMensagem implements Command {
    private Usuario u;
    private Grupo g;

    public ExcluirMensagem(Usuario u, Grupo g) {
        this.u = u;
        this.g = g;
    }

    @Override
    public void executarComando(){
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
            String mensagemASerExcluida = msgAux.getCorpoMsg();
			for(Usuario u : msgAux.getVisualizacaoMensagem()){
                System.out.println("Usuario que vai ter a mensagem excluida: " + u.getNome());
				// g.getMensagem().remove(msgAux);

				u.getMensagem().remove(msgAux);
                removeMensagens(u, mensagemASerExcluida, msgAux);
			}

			System.out.println("MENSAGEM QUE FOI EXCLUIDA: " + msgAux.getCorpoMsg());
			System.out.println("Grupo que o usuário enviou a mensagem: "+ g.getDescricao());
			System.out.println();
		}
    }

    public static void removeMensagens(Usuario u, String mensagemASerExcluida, Mensagem msgAux){
        u.getMensagensGrupo().forEach((grupo, mensagens) -> {
            mensagens.removeIf(msgRemove -> msgRemove.equals(msgAux));
        });
    }   
}
