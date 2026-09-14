package Logica;

import java.util.ArrayList;
import java.time.LocalDate;

public class Compra {
    private ArrayList <Entrada> lista;
    private LocalDate fecha;
    private String metodo_pago;
    private boolean activo;

    public Compra(LocalDate fecha, String metodo_pago) {
        this.lista = new ArrayList <>();
        this.fecha = fecha;
        this.metodo_pago = metodo_pago;
        this.activo = true;
    }    

    public LocalDate getFecha() {
        return fecha;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public Entrada buscarEntradas(int index)
    {
        return this.lista.get(index);
    }
    
    public void añadirEntrada(int id, LocalDate fecha_emision, int precio, int id_sala, int id_funcion, int id_cine)
    {
        Entrada entrada = new Entrada(id, fecha_emision, precio, id_sala, id_funcion, id_cine);
        this.lista.add(entrada);
    }
    
    public void cancelarEntrada(int id, LocalDate fecha)
    {
        // Revisar que la funcion no haya pasado (comparar date de la funcion con la fecha actual)
        this.lista.remove(id);
    }
}