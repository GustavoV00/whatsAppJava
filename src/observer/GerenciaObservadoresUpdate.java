package observer;

public class GerenciaObservadoresUpdate extends GerenciaObservadores{
    private String estado;

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        notificadorObservers();
    }
}
