package interfaces;

import entities.*;
import java.util.*;

// O Observador seria os usuários
public interface Observador {
	public static void atualizarMensagem(String grupo, ArrayList<Mensagem> mensaagem){}
}