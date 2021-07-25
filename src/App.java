import creator.CGrupo;
import creator.CUsuario;
import entities.Grupo;
import entities.TipoMensagem;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
		CUsuario criadorUsuario = new CUsuario();
		CGrupo grupo = new CGrupo();
		Usuario p1 = criadorUsuario.criarUsuario("p1", "419999", "onraine", "foto");
		Usuario p2 = criadorUsuario.criarUsuario("p2", "439999", "ocupado", "foto");
		Usuario p3 = criadorUsuario.criarUsuario("p3", "439999", "ausente", "semFoto");
		Grupo g1 = grupo.criarGrupo("g1", p1);

		Usuario.gerarComandos(p2, TipoMensagem.TEXTO, "test1", g1, p1);
		Usuario.nomeDoComando("Incluir Usuario");
		Usuario.nomeDoComando("Enviar Mensagem");

		Usuario.gerarComandos(p1, TipoMensagem.TEXTO, "TEST2", g1, p1);
		Usuario.nomeDoComando("Enviar Mensagem");

		// p1.incluirUsuario(p2, g1, p3);
		// g1.imprimirInformacoesGrupo(g1);

		// g1.excluirMensagem(p1, g1);
		// g1.imprimirInformacoesGrupo(g1);
		p1.imprimirInformacoesUsuarios(p1);
		p1.imprimirInformacoesUsuarios(p2);
    }
}
