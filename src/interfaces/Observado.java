package interfaces;

import entities.Mensagem;
// Observado seria os grupos
public interface Observado {    
    public void notificaObservadores(Mensagem msg);
}