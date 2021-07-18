package creator;

import entities.Usuario;

public class CUsuario extends FactoryUsuario{

	@Override
	public Usuario criarUsuario(String nome, String telefone, String status, String foto) {
		return new Usuario(nome, telefone, status, foto);
	}
}
