package Logica;
public class Asiento {
    private int id;
    private int fila;
    private int numero;
    private boolean estado;

    public Asiento(int id, int fila, int numero, boolean estado) {
        this.id = id;
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
        System.out.println("El estado es: " + estado);
    }

    public int getId() {
        return id;
    }

    public int getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
