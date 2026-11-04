package Logica;

import java.time.LocalDate;

public class Funcion {
    private LocalDate fecha;
    private int id;
    private int precio_base;
    private Asiento[][] asientos;
    private String hora;
    private int idPelicula;

    public Funcion(LocalDate fecha, int id, int precio_base, int idPelicula, int largo, int ancho, String hora) {
        this.fecha = fecha;
        this.id = id;
        this.precio_base = precio_base;
        this.idPelicula = idPelicula;
        this.asientos = new Asiento[largo][ancho];
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }

    public int getPrecio_base() {
        return precio_base;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public String getHora() {
        return hora;
    }
       
    public Asiento buscarAsiento(int id)
    {
        for(int i = 0; i < this.asientos.length; i ++)
        {
            for(int j = 0; j < this.asientos[0].length; j ++)
            {
                if(this.asientos[i][j].getId() == id)
                {
                    return this.asientos[i][j];
                }
            }
        }
        return null;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }
    
    public void cargarAsiento(int id, int fila, int numero, boolean estado)
    {
        Asiento asiento = new Asiento(id, fila, numero, estado);
        
        this.asientos[fila - 1][numero - 1] = asiento;
    }
    
    public void nuevoAsiento(int sala, int cine, int x, int y)
    {
        String datos = "21;" + this.id + ":" + sala + ":" + cine + ":" + x + ":" + y;
        String[] datos_obtenidos = null;
        int id;
        
        datos_obtenidos = Fachada.getInstancia().getCs().conexion(datos);
        
        id = Integer.parseInt(datos_obtenidos[0]);
        
        Asiento asiento = new Asiento(id, y, x, true);
        
        this.asientos[y][x] =  asiento;
    }
}
