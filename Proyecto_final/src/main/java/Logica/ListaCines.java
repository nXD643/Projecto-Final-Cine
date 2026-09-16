package Logica;

import java.util.ArrayList;

public class ListaCines {
    public ArrayList <Cine> cines;
    private int cineSeleccionado;

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
    
    
}
