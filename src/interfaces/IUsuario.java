package interfaces;

import entities.Grupo;
import entities.Usuario;
import entities.*;
import java.util.*;

public interface IUsuario {
	public void imprimirInformacoesUsuarios(Usuario u, Map<String, ArrayList<String>> usuarioVisualizou);
	public static void gerarComandos(Usuario user, TipoMensagem tipo, String str, Grupo g, Usuario adm){}
}
