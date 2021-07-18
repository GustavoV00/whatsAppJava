package creator;

import entities.Usuario;
import java.util.Date;
import entities.TipoMensagem;
import entities.Mensagem;

public abstract class FactoryMensagem{
    public abstract Mensagem criarMensagem(Usuario autor, TipoMensagem tipoMsg, String corpoMsg, Date dataEnvio, String mensagemGrupo);

}