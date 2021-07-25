import creator.CGrupo;
import creator.CUsuario;
import entities.Grupo;
import entities.TipoMensagem;
import entities.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
		Map<String, ArrayList<Usuario>> usuarioVisualizou = new HashMap<String, ArrayList<Usuario>>();
		ArrayList<Usuario> visualizouAux = new ArrayList<Usuario>();
		CUsuario criadorUsuario = new CUsuario();
		CGrupo grupo = new CGrupo();
		Usuario p1 = criadorUsuario.criarUsuario("p1", "419999", "onraine", "foto");
		Usuario p2 = criadorUsuario.criarUsuario("p2", "439999", "ocupado", "foto");
		Usuario p3 = criadorUsuario.criarUsuario("p3", "439999", "ausente", "semFoto");
		Grupo g1 = grupo.criarGrupo("g1", p1);

		Usuario.gerarComandos(p2, TipoMensagem.TEXTO, "P2 QUE ENVIOU, MSG 1", g1, p1);
		Usuario.nomeDoComando("Incluir Usuario");
		Usuario.nomeDoComando("Enviar Mensagem");

		Usuario.gerarComandos(p1, TipoMensagem.TEXTO, "P1 QUE ENVIOU, MSG 2", g1, p1);
		Usuario.nomeDoComando("Enviar Mensagem");

		// p1.incluirUsuario(p2, g1, p3);
		// g1.imprimirInformacoesGrupo(g1);
		g1.visualizar(p1, g1.getMensagem().get(0));
		atualizaVisualizados(usuarioVisualizou, visualizouAux, g1, p1);
        
		Usuario.nomeDoComando("Excluir Mensagem");

		// g1.imprimirInformacoesGrupo(g1);
		p1.imprimirInformacoesUsuarios(p1, usuarioVisualizou);
		p1.imprimirInformacoesUsuarios(p2, usuarioVisualizou);
		// g1.imprimirInformacoesGrupo(g1); 

    }

	public static void atualizaVisualizados(Map<String, ArrayList<Usuario>> usuarioVisualizou, ArrayList<Usuario> visualizouAux, Grupo g, Usuario u){
		visualizouAux.add(u);
		usuarioVisualizou.put(g.getDescricao(), visualizouAux);
	}
}
