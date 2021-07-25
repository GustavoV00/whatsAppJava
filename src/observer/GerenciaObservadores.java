package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaObservadores {
    private List<UsuarioObserver> observers = new ArrayList<>();

    public void adicionarObservador(UsuarioObserver o){
        this.observers.add(o);
    }

    public void removeObservador(UsuarioObserver o){
        this.observers.remove(o);
    }

    public void notificadorObservers(){
        for(UsuarioObserver observer : observers){
            observer.update();
        }
    }
}
