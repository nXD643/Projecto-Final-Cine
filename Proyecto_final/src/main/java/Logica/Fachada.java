package Logica;

import java.util.ArrayList;

public class Fachada {
    private static Fachada instancia;
    private Cliente cliente;
    private ListaCines cines;
    private ConexionServer cs;

    public Fachada() {
        this.cines = new ListaCines();
        this.cs = new ConexionServer();
    }
    
    public static Fachada getInstancia()
    {
        if(instancia == null)
        {
            instancia = new Fachada();
        }
        return instancia;
    }
    
    private boolean inicio_sesion(Cliente cliente)
    {
        // Hay que terminarlo
        this.cliente = cliente;
        return false;
    }
    
    private void registo(int documento, String nombre, String apellido, String correo_electronico)
    {
        this.cliente = new Cliente(documento, nombre, apellido, correo_electronico);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ListaCines getCines() {
        return cines;
    }
}
