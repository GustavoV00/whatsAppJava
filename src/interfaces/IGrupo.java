package interfaces;

import java.util.*;
import entities.*;

public interface IGrupo {
	public void imprimirInformacoesGrupo(Grupo g);
    public void atualizaQuemNaoVisualizou(Usuario u);
	public void visualizar(Usuario user, Mensagem msg, Map<String, ArrayList<String>> usuarioVisualizou, ArrayList<String> visualizouAux);

}
