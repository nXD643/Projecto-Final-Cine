package Logica;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pelicula {
    private String duracion;
    private int clasificacion_edad;
    private String titulo;
    private int id;
    private ArrayList <String> genero;
    private LocalDate año_estreno;

    public Pelicula(String duracion, int clasificacion_edad, String titulo, int id, LocalDate año_estreno, ArrayList <String> genero) {
        this.duracion = duracion;
        this.clasificacion_edad = clasificacion_edad;
        this.titulo = titulo;
        this.id = id;
        this.genero = genero;
        this.año_estreno = año_estreno;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getClasificacion_edad() {
        return clasificacion_edad;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<String> getGeneros() {
        return genero;
    }

    public LocalDate getAño_estreno() {
        return año_estreno;
    }
}
