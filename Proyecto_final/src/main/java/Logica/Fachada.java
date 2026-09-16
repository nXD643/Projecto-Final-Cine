package Logica;

import java.time.*;
import java.util.ArrayList;
import java.lang.Math;

public class Fachada {
    private static Fachada instancia;
    private Cliente cliente;
    private ListaCines cines;
    private ConexionServer cs;

    private Fachada() {
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
    
    public boolean inicio_sesion(int documento, String contrasena)
    {
        // Hay que terminarlo
        
        if (!verificarCedula(documento))
        {
            return false;
        }
        
        this.cliente = cliente;
        return true;
    }
    
    public boolean registo(int documento, String nombre, String apellido, String correo_electronico, String contrasena, ArrayList telefonos)
    {
        if (!verificarCedula(documento))
        {
            return false;
        }
        this.cliente = new Cliente(documento, nombre, apellido, correo_electronico, contrasena, telefonos);
        
        return true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ListaCines getCines() {
        return cines;
    }
    
    public boolean verificarCancelacion(int idCompra, int idEntrada)
    {        
        int idCine = this.cliente.buscarCompras(idCompra).buscarEntradas(idEntrada).getId_cine();
        int idSala = this.cliente.buscarCompras(idCompra).buscarEntradas(idEntrada).getId_sala();
        int idFuncion = this.cliente.buscarCompras(idCompra).buscarEntradas(idEntrada).getId_funcion();
        
        LocalDate fecha = this.cines.buscarCine(idCine).buscarSala(idSala).buscarFuncion(idFuncion).getFecha();
        String hora = this.cines.buscarCine(idCine).buscarSala(idSala).buscarFuncion(idFuncion).getHora();
        
        String fecha_hora = fecha.toString() + hora;
        LocalDateTime funcion = LocalDateTime.parse(fecha_hora);
        
        LocalDateTime ahora = LocalDateTime.now();
        
        return ahora.isAfter(funcion);
    }
    
    public boolean cancelarEntrada(int idCompra, int idEntrada)
    {
        if (verificarCancelacion(idCompra, idEntrada))
        {
            this.cliente.buscarCompras(idCompra).eliminarEntrada(idEntrada);
            return true;
        }
        return false;
    }
    
    public boolean cancelarCompra(int idCompra)
    {
        if (verificarCancelacion(idCompra, 0))
        {
            this.cliente.eliminarCompra(idCompra);
            return true;
        }
        return false;
    }
    
    public boolean verificarCedula(int cedula)
    {
        int primero = cedula / 10000000;
        
        int segundo = cedula % 10000000;
        segundo /= 1000000;
        
        int tercero = cedula % 1000000;
        tercero /= 100000;
        
        int cuarto = cedula % 100000;
        cuarto /= 10000;
        
        int quinto = cedula % 10000;
        quinto /= 1000;
        
        int sexto = cedula % 1000;
        sexto /= 100;
        
        int septimo = cedula % 100;
        septimo /= 10;
        
        int octavo = cedula % 10;
        
        int verificacion = primero * 8;
        
        verificacion += segundo;
        
        verificacion += tercero * 2;
        
        verificacion += cuarto * 3;
        
        verificacion += quinto * 4;
        
        verificacion += sexto * 7;
        
        verificacion += septimo * 6;
        
        verificacion = verificacion % 10;
                
        if (verificacion > 5)
        {
            verificacion = 10 - verificacion;
        }
        
        return verificacion == octavo;
    }
    
    public int verificarTarjeta(String str_tarjeta)
    {
        int primeros_digitos;
        
        int largo = str_tarjeta.length();
        
        long tarjeta = Long.parseLong(str_tarjeta);
        
        // American Express
        if (largo == 15)
        {
            primeros_digitos = (int) (tarjeta / Math.pow(10, 13));
            
            if (primeros_digitos == 34 || primeros_digitos == 37)
            {
                if (checksum(largo, tarjeta))
                {
                    return 3;
                }
            }
        }
        // Visa
        else if (largo == 13)
        {
            primeros_digitos = (int) (tarjeta / Math.pow(10, 12));
            
            if (primeros_digitos == 4)
            {
                if (checksum(largo, tarjeta))
                {
                    return 1;
                }
            }
        }
        else if (largo == 16)
        {
            primeros_digitos = (int) (tarjeta / Math.pow(10, 14));
            
            // Mastercard
            if (primeros_digitos < 56 & primeros_digitos > 50)
            {
                if (checksum(largo, tarjeta))
                {
                    return 2;
                }
            }
            
            primeros_digitos = (int) (tarjeta / Math.pow(10, 15));
            
            // Visa
            
            if (primeros_digitos == 4)
            {
                if (checksum(largo, tarjeta))
                {
                    return 1;
                }
            }
        }
        return 0;
    }
    
    public boolean checksum(int largo, long tarjeta)
    {
        long multiplicados = 0;
        long simples = 0;
        long digitox2;
        long digito;
        long total;
        long digito_verificador;
        
        for (int i = 0; i < largo; i ++)
        {
            if ((i % 2) == 0)
            {
                digito = tarjeta / (long) (Math.pow(10, ((largo - 1) - i)));
                digito = digito % 10;
                        
                digitox2 = digito * 2;
                if (digitox2 > 9)
                {
                    multiplicados += digitox2 / 10;
                    multiplicados += digitox2 % 10;
                }
                else
                {
                    multiplicados += digitox2;
                }
            }
            else
            {
                digito = tarjeta / (long) (Math.pow(10, ((largo - 1) - i)));
                digito = digito % 10;
                
                simples += digito;
            }
        }
        
        total = multiplicados + simples;
        
        digito_verificador = total % 10;
        return digito_verificador == 0;
    }
}
