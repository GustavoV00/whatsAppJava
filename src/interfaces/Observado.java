package interfaces;

import entities.Mensagem;

public interface Observado {
    public void notificaObservadores(Mensagem msg);
}