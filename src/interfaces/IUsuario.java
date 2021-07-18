package interfaces;

import entities.Grupo;
import entities.Usuario;
import entities.*;
import java.util.*;

public interface IUsuario {
	public void incluirUsuario(Usuario u, Grupo g, Usuario adm);
	public void incluirAdm(Usuario u, Grupo g);
	public void imprimirInformacoesUsuarios(Usuario u);
	public void enviarMensagem(Grupo g, String str, TipoMensagem tipo, Usuario user);
}
