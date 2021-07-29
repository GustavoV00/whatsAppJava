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
		Usuario p4 = criadorUsuario.criarUsuario("p4", "439999", "ausente", "semFoto");
		
        Grupo g1 = grupo.criarGrupo("g1", p1);
		Grupo g2 = grupo.criarGrupo("g2", p1);
    	Grupo g3 = grupo.criarGrupo("g3", p3);

        System.out.println("TESTE DO GRUPO G1");

        p1.gerarComandos(TipoMensagem.TEXTO, "P1 QUE ENVIOU PARA G1, MSG 0", g1, p1);
		p2.gerarComandos(TipoMensagem.TEXTO, "P2 QUE ENVIOU PARA G1, MSG 1", g1, p1);
        p3.gerarComandos(TipoMensagem.TEXTO, "P3 QUE ENVIOU PARA G1, MSG 2", g1, p1);
        p4.gerarComandos(TipoMensagem.TEXTO, "P4 QUE ENVIOU PARA G1, MSG 3", g1, p1);

        p2.nomeDoComando("Incluir Usuario");
        p3.nomeDoComando("Incluir Usuario");
        p4.nomeDoComando("Incluir Usuario");

        p2.nomeDoComando("Enviar Mensagem");
        p1.nomeDoComando("Enviar Mensagem");

        Mensagem msgAux = g1.getMensagem().get(0);
        g1.visualizar(p1, msgAux, usuarioVisualizou, visualizouAux);
        g1.visualizar(p2, msgAux, usuarioVisualizou, visualizouAux);
        g1.visualizar(p3, msgAux, usuarioVisualizou, visualizouAux);
        g1.visualizar(p4, msgAux, usuarioVisualizou, visualizouAux);
        visualizouAux = atualizaQuemVisualizou(visualizouAux);

        msgAux = g1.getMensagem().get(1);
        g1.visualizar(p1, msgAux, usuarioVisualizou, visualizouAux);
        g1.visualizar(p2, msgAux, usuarioVisualizou, visualizouAux);
        g1.visualizar(p3, msgAux, usuarioVisualizou, visualizouAux);
        g1.visualizar(p4, msgAux, usuarioVisualizou, visualizouAux);
        visualizouAux = atualizaQuemVisualizou(visualizouAux);

		p1.imprimirInformacoesUsuarios(p1, usuarioVisualizou);
		p2.imprimirInformacoesUsuarios(p2, usuarioVisualizou);
		p3.imprimirInformacoesUsuarios(p3, usuarioVisualizou);
		p4.imprimirInformacoesUsuarios(p4, usuarioVisualizou);

        g1.imprimirInformacoesGrupo(g1);


        System.out.println("FIM DO TESTE DO GRUPO G1");
        System.out.println("----------------------------------------------------------");

       
        System.out.println("INICIO DOS TESTES DO GRUPO G2");

        p2.gerarComandos(TipoMensagem.TEXTO, "P2 QUE ENVIOU PARA G2, MSG 1", g2, p1);
        p3.gerarComandos(TipoMensagem.TEXTO, "P3 QUE ENVIOU PARA G2, MSG 2", g2, p1);
    
        p2.nomeDoComando("Incluir Usuario");
        p3.nomeDoComando("Incluir Usuario");
    
        p2.nomeDoComando("Enviar Mensagem");
        p3.nomeDoComando("Enviar Mensagem");
    
        msgAux = g2.getMensagem().get(0);
        g2.visualizar(p1, msgAux, usuarioVisualizou, visualizouAux);
        g2.visualizar(p2, msgAux, usuarioVisualizou, visualizouAux);
        visualizouAux = atualizaQuemVisualizou(visualizouAux);

        msgAux = g2.getMensagem().get(1);
        g2.visualizar(p1, msgAux, usuarioVisualizou, visualizouAux);
        g2.visualizar(p2, msgAux, usuarioVisualizou, visualizouAux);
        visualizouAux = atualizaQuemVisualizou(visualizouAux);

		p1.imprimirInformacoesUsuarios(p1, usuarioVisualizou);
		p2.imprimirInformacoesUsuarios(p2, usuarioVisualizou);
		p3.imprimirInformacoesUsuarios(p3, usuarioVisualizou);
        visualizouAux = atualizaQuemVisualizou(visualizouAux);

        g2.imprimirInformacoesGrupo(g2);

        System.out.println("FIM DO TESTES DO GRUPO G2");
        System.out.println("-----------------------------------------------------");

        System.out.println("INICIO DE TESTE DO GRUPO G3");

        p3.gerarComandos(TipoMensagem.TEXTO, "P3 QUE ENVIOU PARA G3, MSG 0", g3, p3);
        p4.gerarComandos(TipoMensagem.TEXTO, "P4 QUE ENVIOU PARA G3, MSG 1", g3, p3);
    
        p4.nomeDoComando("Incluir Usuario");
    
        p3.nomeDoComando("Enviar Mensagem");
        p3.nomeDoComando("Excluir Mensagem");
        p3.nomeDoComando("Enviar Mensagem");
        p3.nomeDoComando("Enviar Mensagem");
    
        msgAux = g3.getMensagem().get(0);
        p3.imprimirInformacoesUsuarios(p3, usuarioVisualizou);
        p4.imprimirInformacoesUsuarios(p4, usuarioVisualizou);

        g3.imprimirInformacoesGrupo(g3);

        System.out.println("FIM DE TESTE DO GRUPO G3");
        System.out.println("-----------------------------------------------------");

    }

	public static ArrayList<String> atualizaQuemVisualizou(ArrayList<String> visualizouAux){
        visualizouAux = null;
        ArrayList<String> test = new ArrayList<String>();
        return test;
	}
}
