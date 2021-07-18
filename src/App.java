import creator.CUsuario;
import creator.CGrupo;
import entities.Usuario;
import entities.Grupo;
import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
		private static FactoryGrupo grupo;
		CUsuario criadorUsuario = new CUsuario();
		CGrupo grupo = new CGrupo();
		Usuario p1 = criadorUsuario.criarUsuario("p1", "419999", "onraine", "foto");
		Usuario p2 = criadorUsuario.criarUsuario("p2", "439999", "ocupado", "foto");
		Usuario p3 = criadorUsuario.criarUsuario("p3", "439999", "ausente", "semFoto");
		Grupo g1 = grupo.criarGrupo("g1", p1);

		p1.enviarMensagem(g1, "mensagem legal 2", TipoMensagem.TEXTO, p1 );
		p1.enviarMensagem(g1, "mensagem legal", TipoMensagem.TEXTO, p1 );

		p1.incluirUsuario(p2, g1, p3);
		// g1.imprimirInformacoesGrupo(g1);

		g1.excluirMensagem(p1, g1);
		// g1.imprimirInformacoesGrupo(g1);
		p1.imprimirInformacoesUsuarios(p1);
		p1.imprimirInformacoesUsuarios(p2);
    }
}