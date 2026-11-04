package Logica;
public class Empleado {
    private int documento; 
    private String nombre;
    private String apellido;
    private String contrasena;
    private int idCine; 

    public Empleado(int documento, String nombre, String apellido, String contrasena, int idCine) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.idCine = idCine;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getIdCine() {
        return idCine;
    }
}
