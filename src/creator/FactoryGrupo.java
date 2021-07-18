package creator;

import entities.Grupo;
import entities.Usuario;

public abstract class FactoryGrupo {
	public abstract Grupo criarGrupo(String descricao, Usuario criadorDoGrupo);
}