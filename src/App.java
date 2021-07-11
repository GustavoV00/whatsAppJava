import creator.CGrupo;
import creator.CMensagem;
import creator.CUsuario;
import entities.Grupo;
import entities.Mensagem;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
		CUsuario criadorUsuario = new CUsuario();
		Usuario p1 = criadorUsuario.criarUsuario("nome", "419999", "onraine", "foto");
		System.out.println(p1.toString());

		CGrupo criadorGrupo = new CGrupo();
		Grupo g1 = criadorGrupo.criarGrupo("test");
		System.out.println(g1.toString());
    
    
		CMensagem ciradorMensagem = new CMensagem();
		Mensagem m1 = ciradorMensagem.criarMensagem(p1) ;
		System.out.println(m1.toString());
    }
}