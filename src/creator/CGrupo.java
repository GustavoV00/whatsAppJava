package creator;

import entities.Grupo;
import entities.Usuario;

public class CGrupo extends FactoryGrupo{
	
	@Override
	public Grupo criarGrupo(String descricao, Usuario criadorDoGrupo) {
		
		Grupo g = new Grupo(descricao);
		
		Usuario.gerarComandos(criadorDoGrupo, null, null, g, criadorDoGrupo);
		Usuario.nomeDoComando("Incluir Usuario Adm");
		Usuario.nomeDoComando("Incluir Usuario");

//		criadorDoGrupo.incluirAdm(criadorDoGrupo, g);
//		criadorDoGrupo.incluirUsuario(criadorDoGrupo, g, criadorDoGrupo);
		return g;
	}
}

	