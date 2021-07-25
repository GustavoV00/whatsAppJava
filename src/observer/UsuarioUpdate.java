package observer;

public class UsuarioUpdate extends UsuarioObserver {
    
    @Override
    public void update() {
        System.out.println("Observer notificado!\n");
    }
}
