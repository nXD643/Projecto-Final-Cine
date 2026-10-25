package Logica;

import java.util.ArrayList;

public class ListaCines {
    public ArrayList <Cine> cines;
    private int cineSeleccionado = -1;
    private int peliculaSeleccionada;
    private int salaSeleccionada;
    private int funcionSeleccionada;
    private ArrayList <Asiento> asientosSeleccionados = new ArrayList <> ();
    
    public ListaCines() {
        this.cines = new ArrayList <>();
    }   
    
    public Cine buscarCine(int id)
    {
        return this.cines.get(id);
    }
    
    public void cargarCine(String calle, String ciudad, int id, String nombre)
    {
        Cine cine = new Cine(calle, ciudad, id, nombre);
        
        this.cines.add(cine);
    }

    public int getCineSeleccionado() {
        return cineSeleccionado;
    }

    public void setCineSeleccionado(int cineSeleccionado) {
        this.cineSeleccionado = cineSeleccionado;
    }
    
    public int getSize()
    {
        return this.cines.size();
    }
    
    public int getPeliculaSeleccionada() {
        return peliculaSeleccionada;
    }

    public void setPeliculaSeleccionada(int peliculaSeleccionada) {
        this.peliculaSeleccionada = peliculaSeleccionada;
    }
    
    public int getSalaSeleccionada() {
        return salaSeleccionada;
    }

    public void setSalaSeleccionada(int salaSeleccionada) {
        this.salaSeleccionada = salaSeleccionada;
    }

    public int getFuncionSeleccionada() {
        return funcionSeleccionada;
    }

    public void setFuncionSeleccionada(int funcionSeleccionada) {
        this.funcionSeleccionada = funcionSeleccionada;
    }

    public ArrayList<Asiento> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }

    public void setAsientosSeleccionados(ArrayList<Asiento> asientosSeleccionados) {
        this.asientosSeleccionados = asientosSeleccionados;
    }
}
