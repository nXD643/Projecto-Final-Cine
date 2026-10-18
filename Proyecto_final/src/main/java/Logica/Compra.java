package Logica;

import java.util.ArrayList;
import java.time.LocalDate;

public class Compra {
    private ArrayList <Entrada> lista;
    private LocalDate fecha;
    private String hora;
    private String metodo_pago;
    private boolean activo;
    private String motivo;
    private int importe_total;

    public Compra(LocalDate fecha, String hora, String metodo_pago, boolean activo, int importe_total) {
        this.lista = new ArrayList <>();
        this.fecha = fecha;
        this.hora = hora;
        this.metodo_pago = metodo_pago;
        this.activo = activo;
        this.importe_total = importe_total;
    }   
    
    public Compra(LocalDate fecha, String hora, String metodo_pago, boolean activo, String motivo, int importe_total) {
        this.lista = new ArrayList <>();
        this.fecha = fecha;
        this.hora = hora;
        this.metodo_pago = metodo_pago;
        this.activo = activo;
        this.motivo = motivo;
        this.importe_total = importe_total;
    }   

    public LocalDate getFecha() {
        return fecha;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public int getImporte_total() {
        return importe_total;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public Entrada buscarEntradas(int index)
    {
        return this.lista.get(index);
    }
    
    public void anadirEntrada(String datos)
    {
        String[] valores_str = null;
        Integer[] valores = null;
        
        valores_str = datos.split(":");
        
        System.out.println(datos);
        
        valores = Fachada.getInstancia().convertirInt(valores_str);
                
        Entrada entrada = new Entrada(valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]);
        this.lista.add(entrada);
    }
    
    public void eliminarEntrada(int id)
    {
        this.lista.remove(id);
    }
}