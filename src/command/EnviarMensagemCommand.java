package command;

import java.util.Date;

import creator.CMensagem;
import entities.Grupo;
import entities.Mensagem;
import entities.TipoMensagem;
import entities.Usuario;

public class EnviarMensagemCommand implements Command{
    private Usuario user;
    private TipoMensagem tipo;
    private String str;
    private Grupo g;

    public EnviarMensagemCommand(Usuario user, TipoMensagem tipo, String str, Grupo g) {
        this.user = user;
        this.tipo = tipo;
        this.str = str;
        this.g = g;
    }
    
    @Override
    public void executarComando() {
		CMensagem criadorMensagen = new CMensagem();
		Mensagem msg = criadorMensagen.criarMensagem(user, tipo, str, new Date(), g.getDescricao());
		g.getMensagem().add(msg);
        user.getMensagem().add(msg);
    }
}