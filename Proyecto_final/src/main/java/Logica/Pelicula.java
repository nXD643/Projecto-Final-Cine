package Logica;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pelicula {
    private String duracion;
    private String clasificacion_edad;
    private String titulo;
    private int id;
    private ArrayList <String> genero;
    private LocalDate ano_estreno;

    public Pelicula(String duracion, String clasificacion_edad, String titulo, int id, LocalDate ano_estreno, ArrayList <String> genero) {
        this.duracion = duracion;
        this.clasificacion_edad = clasificacion_edad;
        this.titulo = titulo;
        this.id = id;
        this.genero = genero;
        this.ano_estreno = ano_estreno;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getClasificacion_edad() {
        return clasificacion_edad;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<String> getGeneros() {
        return genero;
    }

    public LocalDate getAno_estreno() {
        return ano_estreno;
    }
}
