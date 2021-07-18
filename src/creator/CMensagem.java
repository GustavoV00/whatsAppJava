package creator;

import entities.Mensagem;
import entities.Usuario;
import entities.TipoMensagem;
import java.util.*;

public class CMensagem extends FactoryMensagem{

	@Override
	public Mensagem criarMensagem(Usuario autor, TipoMensagem tipoMsg, String corpoMsg, Date dataEnvio, String mensagemGrupo) {
		return new Mensagem(autor, tipoMsg, corpoMsg, dataEnvio, mensagemGrupo);
	}
}