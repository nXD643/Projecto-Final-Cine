package Logica;
public class Asiento {
    private int id;
    private boolean estado;

    public Asiento(int id, boolean estado) {
        this.id = id;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
