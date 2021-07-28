package interfaces;

import entities.Grupo;
import entities.Usuario;
import entities.*;
import java.util.*;

public interface IUsuario {
//	public void incluirUsuario(Usuario u, Grupo g, Usuario adm);
//	public void incluirAdm(Usuario u, Grupo g);
	public void imprimirInformacoesUsuarios(Usuario u, Map<String, ArrayList<String>> usuarioVisualizou);
	public static void gerarComandos(Usuario user, TipoMensagem tipo, String str, Grupo g, Usuario adm){}
	public static void atualizarMensagem(String grupo, ArrayList<Mensagem> mensaagem){}
}
