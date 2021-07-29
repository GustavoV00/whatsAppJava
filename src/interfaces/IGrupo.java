package interfaces;

import java.util.*;
import entities.*;

public interface IGrupo {
	public void imprimirInformacoesGrupo(Grupo g);
	//public void excluirMensagem(Usuario u, Grupo g);
    public void atualizaQuemNaoVisualizou(Usuario u);
//	public void notificaObservadores(Mensagem msg);
	public void visualizar(Usuario user, Mensagem msg, Map<String, ArrayList<String>> usuarioVisualizou, ArrayList<String> visualizouAux);

}
