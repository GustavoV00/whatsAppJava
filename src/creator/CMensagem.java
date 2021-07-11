package creator;

import entities.Mensagem;
import entities.Usuario;

public class CMensagem {
	public Mensagem criarMensagem(Usuario autor) {
		return new Mensagem(autor);
	}
}
