package Logica;

public class Entrada {
    private int id;
    private int precio;
    private int id_sala;
    private int id_funcion;
    private int id_cine;
    private int id_asiento;

    public Entrada(int id, int precio, int id_sala, int id_funcion, int id_cine, int id_asiento) {
        this.id = id;
        this.precio = precio;
        this.id_sala = id_sala;
        this.id_funcion = id_funcion;
        this.id_cine = id_cine;
        this.id_asiento = id_asiento;
    }

    public int getId() {
        return id;
    }

    public int getPrecio() {
        return precio;
    }

    public int getId_sala() {
        return id_sala;
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public int getId_cine() {
        return id_cine;
    }    
}