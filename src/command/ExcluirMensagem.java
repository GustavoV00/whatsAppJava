package command;

import entities.*;
import java.util.ArrayList;

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
			System.out.println("MENSAGEM QUE FOI EXCLUIDA: " + msgAux.getCorpoMsg());
            String mensagemASerExcluida = msgAux.getCorpoMsg();
			for(Usuario u : msgAux.getVisualizacaoMensagem()){
                System.out.println("Usuario que vai ter a mensagem excluida: " + u.getNome());
				// g.getMensagem().remove(msgAux);

				u.getMensagem().remove(msgAux);
                removeMensagens(u, mensagemASerExcluida, msgAux, g);
			}

			System.out.println("Grupo que o usuário enviou a mensagem: "+ g.getDescricao());
			System.out.println();
		}
    }

    public static void removeMensagens(Usuario u, String mensagemASerExcluida, Mensagem msgAux, Grupo g){
        ArrayList<Mensagem> mensagensNaoExcluidas = new ArrayList<Mensagem>();
        u.getMensagensGrupo().forEach((grupo, mensagens) -> {
            for(Mensagem msg : mensagens){
                if(msg.getCorpoMsg() != mensagemASerExcluida) 
                    mensagensNaoExcluidas.add(msg);
            }
        });
        u.getMensagensGrupo().put(g.getDescricao(), mensagensNaoExcluidas);

    }   
}
