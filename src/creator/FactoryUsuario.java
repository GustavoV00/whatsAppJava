package creator;

import entities.Usuario;

public abstract class FactoryUsuario{

	public abstract Usuario criarUsuario(String nome, String telefone, String status, String foto);
}
