package Logica;

import java.time.LocalDate;

public class Entrada {
    private int id;
    private LocalDate fecha_emision;
    private int precio;
    private int id_sala;
    private int id_funcion;
    private int id_cine;

    public Entrada(int id, LocalDate fecha_emision, int precio, int id_sala, int id_funcion, int id_cine) {
        this.id = id;
        this.fecha_emision = fecha_emision;
        this.precio = precio;
        this.id_sala = id_sala;
        this.id_funcion = id_funcion;
        this.id_cine = id_cine;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha_emision() {
        return fecha_emision;
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