package creator;

import entities.Grupo;
import entities.Usuario;

public class CGrupo extends FactoryGrupo{
	
	@Override
	public Grupo criarGrupo(String descricao, Usuario criadorDoGrupo) {
		
		Grupo g = new Grupo(descricao);
		
		criadorDoGrupo.gerarComandos(null, null, g, criadorDoGrupo);
		criadorDoGrupo.nomeDoComando("Incluir Usuario Adm");
		criadorDoGrupo.nomeDoComando("Incluir Usuario");

		return g;
	}
}

	
