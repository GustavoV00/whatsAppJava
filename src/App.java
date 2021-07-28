import creator.CGrupo;
import creator.CUsuario;
import entities.Grupo;
import entities.TipoMensagem;
import entities.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
		Map<String, ArrayList<String>> usuarioVisualizou = new HashMap<String, ArrayList<String>>();
		ArrayList<String> visualizouAux = new ArrayList<String>();
		CUsuario criadorUsuario = new CUsuario();
		CGrupo grupo = new CGrupo();
		Usuario p1 = criadorUsuario.criarUsuario("p1", "419999", "onraine", "foto");
		Usuario p2 = criadorUsuario.criarUsuario("p2", "439999", "ocupado", "foto");
		Usuario p3 = criadorUsuario.criarUsuario("p3", "439999", "ausente", "semFoto");
		Grupo g1 = grupo.criarGrupo("g1", p1);
		Grupo g2 = grupo.criarGrupo("g2", p1);

		p2.gerarComandos(TipoMensagem.TEXTO, "P2 QUE ENVIOU PARA G1, MSG 1", g1, p1);
        p2.nomeDoComando("Incluir Usuario");
        p2.nomeDoComando("Enviar Mensagem");

        p2.gerarComandos(TipoMensagem.TEXTO, "P2 QUE ENVIOU PARA G1, MSG 2", g1, p1);
        p2.nomeDoComando("Enviar Mensagem");

        p2.gerarComandos(TipoMensagem.TEXTO, "P2 QUE ENVIOU PARA G1, MSG 3", g1, p1);
        p2.nomeDoComando("Enviar Mensagem");

        p3.gerarComandos(TipoMensagem.TEXTO, "P3 QUE ENVIOU PARA G1, MSG 4", g1, p1);
        p3.nomeDoComando("Incluir Usuario");
        p3.nomeDoComando("Enviar Mensagem");


        // Seleciona a ultima mensagem do grupo | ou a primeira, tenho que debugar
        Mensagem msgAux =  g1.getMensagem().get(0);
        msgAux.imprimeMensagens(g1);
		g1.visualizar(p1, msgAux, usuarioVisualizou, visualizouAux);
		g1.visualizar(p2, msgAux, usuarioVisualizou, visualizouAux);

		visualizouAux = atualizaQuemVisualizou(visualizouAux);
		msgAux =  g1.getMensagem().get(1);
		g1.visualizar(p1, msgAux, usuarioVisualizou, visualizouAux);
		g1.visualizar(p2, msgAux, usuarioVisualizou, visualizouAux);

        // p2.nomeDoComando("Excluir Mensagem");



		p1.imprimirInformacoesUsuarios(p1, usuarioVisualizou);
		p1.imprimirInformacoesUsuarios(p2, usuarioVisualizou);
		p3.imprimirInformacoesUsuarios(p3, usuarioVisualizou);
//		g1.imprimirInformacoesGrupo(g1); 
//		g2.imprimirInformacoesGrupo(g2); 
    }

	public static ArrayList<String> atualizaQuemVisualizou(ArrayList<String> visualizouAux){
        visualizouAux = null;
        ArrayList<String> test = new ArrayList<String>();
        return test;
	}
}
