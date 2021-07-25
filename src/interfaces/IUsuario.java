package interfaces;

import entities.Grupo;
import entities.Usuario;
import entities.*;

public interface IUsuario {
//	public void incluirUsuario(Usuario u, Grupo g, Usuario adm);
//	public void incluirAdm(Usuario u, Grupo g);
	public void imprimirInformacoesUsuarios(Usuario u);
	public static void gerarComandos(Usuario user, TipoMensagem tipo, String str, Grupo g, Usuario adm){}
}
