package command;

import entities.Grupo;
import entities.Usuario;

public class IncluiUsuarioComumCommand implements Command {
    private Usuario u;
    private Usuario adm;
    private Grupo g;

    public IncluiUsuarioComumCommand(Usuario u, Usuario adm, Grupo g) {
        this.u = u;
        this.adm = adm;
        this.g = g;
    }

    @Override
    public void executarComando() {
		if(adm == g.getArrayAdm().get(0)) {
			u.getGrupos().add(g);
			g.getUsuarios().add(u);

		}else
			System.out.println("Usuario nao eh adiministrador");
    }
}
