package Logica;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    private ArrayList <Compra> compras;
    private int documento; 
    private String nombre;
    private String apellido;
    private String correo_electronico;
    private ArrayList <String> telefonos;
    private String contrasena;

    public Cliente(int documento, String nombre, String apellido, String correo_electronico, String contrasena) {
        this.compras = new ArrayList <>();
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.telefonos = new ArrayList <>();
        this.contrasena = contrasena;
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

    public String getContrasena() {
        return contrasena;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
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

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public boolean cargarCompras(String datos, int id_compra)
    {
        String[] valores = null;
        String[] resultado = null;
        
        valores = datos.split("/");
        
        System.out.println(datos);
        
        LocalDate fecha = LocalDate.parse(valores[0]);
        
        if (Boolean.valueOf(valores[4]))
        {
            Compra compra = new Compra(fecha, valores[1], valores[2], Boolean.valueOf(valores[4]), Integer.parseInt(valores[5]));
            this.compras.add(compra);
            
            this.compras.getLast().setId_db(Integer.parseInt(valores[6]));
            
            datos = "10;" + valores[6];
            resultado = Fachada.getInstancia().getCs().conexion(datos);
            
            for (int i = 0; i < resultado.length; i ++)
            {
                this.buscarCompras(id_compra).cargarEntrada(resultado[i]);
            }
            return true;
        }
        else
        {
            Compra compra = new Compra(fecha, valores[1], valores[2], Boolean.valueOf(valores[4]), valores[3], Integer.parseInt(valores[6]));
            this.compras.add(compra); 
            
            this.compras.getLast().setId_db(Integer.parseInt(valores[6]));
            
            datos = "10;" + valores[6];
            resultado = Fachada.getInstancia().getCs().conexion(datos);
            
            for (int i = 0; i < resultado.length; i ++)
            {
                this.buscarCompras(id_compra).cargarEntrada(resultado[i]);
            }
            return true;
        }
    }
        
    public Compra buscarCompras(int index)
    {
        return this.compras.get(index);
    }
    
    public void agregarTelefono(String telefono)
    {
        telefonos.add(telefono);
    }
    
    public boolean guardarTelefono(int documentos, String telefonos)
    {
        String[] telefono = telefonos.split(":");
        String datos;
        String[] resultado = null;
        
        for (int i = 0; i < telefono.length; i++) {
            
                datos = "12;" + documento + ":" + telefono[i];
                
                resultado = Fachada.getInstancia().getCs().conexion(datos);
                
                if (!Boolean.valueOf(resultado[0]))
                {
                    return false;
                }
                this.telefonos.add(telefono[i]);
        }
        return true;
    }
    
    
    public boolean eliminarTelefono(String telefono)
    {
        String datos = "13;" + telefono;
        String[] resultado = null;
        
        resultado = Fachada.getInstancia().getCs().conexion(datos);
        
        if (!Boolean.parseBoolean(resultado[0]))
        {
            return false;
        }
        
        this.telefonos.remove(telefono);
        
        return true;
    }
    
    public int guardarCompras(int documento, LocalDate fecha, String hora, String metodo_pago, int importe_total)
    {
        String datos = "14;" + documento + "/" + importe_total + "/" + fecha + "/" + hora + "/" + metodo_pago;
        String[] resultado = null;
        
        resultado = Fachada.getInstancia().getCs().conexion(datos);
        
        if (resultado[0].equals(""))
        {
            return 0;
        }
        
        Compra compra = new Compra(fecha, hora, metodo_pago, true, importe_total);
        
        this.compras.add(compra);
        
        this.compras.getLast().setId_db(Integer.parseInt(resultado[0]));
        
        return Integer.parseInt(resultado[0]);
    }
    
    public boolean cancelarCompra(Compra compra, String motivo)
    {
        int id = -1;

        String datos = "15;" + compra.getId_db() + ":" + motivo;
        String[] resultado = null;

        resultado = Fachada.getInstancia().getCs().conexion(datos);

        if (!Boolean.parseBoolean(resultado[0]))
        {
            return false;
        }

        compra.setActivo(false);
        
        return true;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }
}
