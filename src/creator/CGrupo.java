package creator;


import entities.Grupo;

public class CGrupo {
	public Grupo criarGrupo(String descricao) {
		return new Grupo(descricao);
	}
}
