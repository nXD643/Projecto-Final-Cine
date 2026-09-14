package Logica;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sala {
    private int numero;
    private int id;
    private int capacidad_maxima;
    private ArrayList <Funcion> funciones;
    private int largo;
    private int ancho;

    public Sala(int numero, int id, int capacidad_maxima, int largo, int ancho) {
        this.numero = numero;
        this.id = id;
        this.capacidad_maxima = capacidad_maxima;
        this.funciones = new ArrayList <>();
        this.largo = largo;
        this.ancho = ancho;
    }

    public int getNumero() {
        return numero;
    }

    public int getId() {
        return id;
    }

    public int getCapacidad_maxima() {
        return capacidad_maxima;
    }
    
    public Funcion buscarFuncion(int id)
    {
        return this.funciones.get(id);
    }
    
    public void cargarFuncion(LocalDate fecha, int id, int precio_base, Pelicula pelicula)
    {
        Funcion funcion = new Funcion(fecha, id, precio_base, pelicula, this.largo, this.ancho);
        
        this.funciones.add(funcion);
    }
}
