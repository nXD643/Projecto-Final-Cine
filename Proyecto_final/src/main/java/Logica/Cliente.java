package Logica;

import java.util.ArrayList;

public class Cliente {
    private ArrayList <Compra> compras;
    private int documento; 
    private String nombre;
    private String apellido;
    private String correo_electronico;
    private ArrayList <String> telefonos;

    public Cliente(int documento, String nombre, String apellido, String correo_electronico) {
        this.compras = new ArrayList <>();;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.telefonos = new ArrayList <>();
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    
    public Compra buscarCompras(int index)
    {
        return this.compras.get(index);
    }
}
