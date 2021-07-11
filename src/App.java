import creator.CUsuario;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
		CUsuario criadorUsuario = new CUsuario();
		Usuario p1 = criadorUsuario.criarUsuario("p1", "419999", "onraine", "foto");

		p1.criarGrupo("g1", p1);
		p1.imprimirInformacoesUsuarios(p1);
    
    }
}