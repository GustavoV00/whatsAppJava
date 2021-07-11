package interfaces;

import entities.Grupo;

public interface IUsuario {
	public Grupo criarGrupo();
	public void incluirUsuario();
	public void incluirAdm();
	public void enviarMensagem();
	public void imprimirInformacoesUsuarios();
}
