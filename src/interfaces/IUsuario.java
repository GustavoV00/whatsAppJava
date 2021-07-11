package interfaces;

import entities.Grupo;
import entities.Usuario;

public interface IUsuario {
	public Grupo criarGrupo(String descricao, Usuario criadorDoGrupo);
	public void incluirUsuario(Usuario u, Grupo g);
	public void incluirAdm(Usuario u, Grupo g);
	public void imprimirInformacoesUsuarios();
}
