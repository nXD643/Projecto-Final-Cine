package Logica;

import java.util.ArrayList;

public class Cine {
    private String calle;
    private String ciudad;
    private int id;
    private String nombre;
    private ArrayList <Sala> salas;

    public Cine(String calle, String ciudad, int id, String nombre) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.id = id;
        this.nombre = nombre;
        this.salas = new ArrayList <>();
    }

    public String getCalle() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Sala buscarSala(int id)
    {
        return this.salas.get(id);
    }
    
    public void cargarSala(int numero, int id, int capacidad_maxima, int largo_asientos, int ancho_asientos)
    {
        Sala sala = new Sala(numero, id, capacidad_maxima, largo_asientos, ancho_asientos);
        
        this.salas.add(sala);
    }
}
