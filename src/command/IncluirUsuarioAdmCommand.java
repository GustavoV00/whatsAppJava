package command;

import entities.Grupo;
import entities.Usuario;

public class IncluirUsuarioAdmCommand implements Command {
    private Usuario adm;
    private Grupo g;

    public IncluirUsuarioAdmCommand(Usuario adm, Grupo g){
        this.adm = adm;
        this.g = g;
    }

    @Override
    public void executarComando() {
        g.getArrayAdm().add(adm);
    }
}
