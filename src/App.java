import creator.CUsuario;
import entities.Usuario;
import entities.Grupo;
import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
		CUsuario criadorUsuario = new CUsuario();
		Usuario p1 = criadorUsuario.criarUsuario("p1", "419999", "onraine", "foto");

		Grupo g1 = p1.criarGrupo("g1", p1);
		p1.enviarMensagem(g1, "mensagem legal", TipoMensagem.TEXTO, p1 );
    	p1.imprimirInformacoesUsuarios(p1);

    }
}