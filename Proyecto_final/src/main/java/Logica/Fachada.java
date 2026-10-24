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
        String datos;
        String[] resultado = null;
        String[] valores = null;
        String[] telefonos;
        
        if (!verificarCedula(documento))
        {
            return false;
        }
        datos = "2;" + documento + ":" + contrasena;
        
        resultado = cs.conexion(datos);
        
        System.out.println(resultado[0]);
        
        valores = resultado[0].split(":");
        
        this.cliente = new Cliente(documento, valores[0], valores[1], valores[2], contrasena);
        
        telefonos = valores[3].split("/");
        
        for (int i = 0; i < telefonos.length; i ++)
        {
            this.cliente.agregarTelefono(telefonos[i]);
        }
        
        try
        {
            datos = "3;" + documento;

            resultado = cs.conexion(datos);

            for (int i = 0; i < resultado.length; i ++)
            {
                this.cliente.cargarCompras(resultado[i], i);
            }
            return true;
        }
        catch (Exception e)
        {
            System.out.println("No tiene compras");
        }
        return true;
    }
    public boolean registro(int documento, String nombre, String apellido, String correo_electronico, String contrasena, String telefonos)
    {
        String datos;
        String[] resultado = null;
        
        if (!verificarCedula(documento))
        {
            return false;
        }
        this.cliente = new Cliente(documento, nombre, apellido, correo_electronico, contrasena);

        this.cliente.agregarTelefono(telefonos);
        
        datos = "1;" + documento + ":" + nombre + ":" + apellido + ":" + correo_electronico + ":" + contrasena + ":" + telefonos;
        
        resultado = cs.conexion(datos);
        
        return Boolean.valueOf(resultado[0]);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ListaCines getCines() {
        return cines;
    }

    public ConexionServer getCs() {
        return cs;
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
    public boolean anadir_cines()
    {
        String datos;
        String[] resultado = null;
        String[] resultado_salas = null;
        String[] valores = null;
        Integer[] valores_sala = null;
        
        datos = "4;";
        
        resultado = cs.conexion(datos);
        
        System.out.println(resultado[0]);
        
        for (int i = 0; i < resultado.length; i ++)
        {
            valores = resultado[i].split(":");
            
            this.cines.cargarCine(valores[1], valores[2], Integer.parseInt(valores[0]), valores[3]);
        }
        
        return true;
    }
    public boolean anadir_peliculas (int id_pelicula)
    {
        String datos = "7;" + id_pelicula;
        String[] resultado = null;
        String[] valores = null;
        ArrayList<String> generos = null;
        LocalDate anio_estreno;
        int id_cine = this.cines.getCineSeleccionado();
        
        resultado = cs.conexion(datos);
        
        for (int i = 0; i < resultado.length; i ++)
        {
            valores = resultado[i].split(":");
            
            generos = obtener_generos(Integer.parseInt(valores[3]));

            anio_estreno = LocalDate.parse(valores[4]);
            
            System.out.println(this.cines.buscarCine(id_cine).ListaPeliculas().size());
            
            if (this.cines.buscarCine(id_cine).ListaPeliculas().size() != 0)
            {
                for (int j = 0; j < this.cines.buscarCine(id_cine).ListaPeliculas().size(); j ++)
                {
                    Pelicula pelicula = new Pelicula(valores[0], valores[1], valores[2], Integer.parseInt(valores[3]), anio_estreno, generos);
                    
                    if (!this.cines.buscarCine(id_cine).obtenerPeliculas(j).getTitulo().equals(pelicula.getTitulo()))
                    {
                        this.cines.buscarCine(id_cine).cargarPelicula(pelicula);
                    }
                }
            }
            else
            {
                Pelicula pelicula = new Pelicula(valores[0], valores[1], valores[2], Integer.parseInt(valores[3]), anio_estreno, generos);

                this.cines.buscarCine(id_cine).cargarPelicula(pelicula);
            }
        }
        
        return true;
    }
    public ArrayList<String> obtener_generos (int id_pelicula)
    {
        String datos = "8;" + id_pelicula;
        String[] resultado = null;
        String[] valores = null;
        ArrayList<String> generos = new ArrayList<>();
        
        resultado = cs.conexion(datos);
        
        for (int i = 0; i < resultado.length; i ++)
        {
            valores = resultado[i].split(":");
            
            generos.add(valores[0]);
        }
        return generos;
    }
    public boolean anadir_salas ()
    {
        String[] resultado = null;
        String[] valores = null;
        Integer[] valores_sala = null;  
        int id_cine = this.cines.getCineSeleccionado();
        
        String datos = "5;" + this.cines.buscarCine(id_cine).getId();
        
        resultado = cs.conexion(datos);

        for (int i = 0; i < resultado.length; i ++)
        {
            valores = resultado[i].split(":");

            valores_sala = convertirInt(valores);

            this.cines.buscarCine(id_cine).cargarSala(valores_sala[1], valores_sala[2], valores_sala[3], valores_sala[4], valores_sala[5]);

            anadir_funciones(valores_sala[2], i);
        }
        
        return true;
    }
    public boolean anadir_funciones(int id_sala, int index)
    {
        String datos;
        String[] resultado = null;
        String[] valores = null;
        LocalDate fecha;
        int id_cine = this.cines.getCineSeleccionado();
        
        datos = "6;" + id_sala;
                
        resultado = cs.conexion(datos);
        
        System.out.println(resultado[0]);
        
        for (int i = 0; i < resultado.length; i ++)
        {
            valores = resultado[i].split("\\.");
            
            fecha = LocalDate.parse(valores[0]);
            
            this.cines.buscarCine(id_cine).buscarSala(index).cargarFuncion(fecha, Integer.parseInt(valores[1]), Integer.parseInt(valores[2]), Integer.parseInt(valores[3]), valores[4]);
            
            anadir_peliculas(Integer.parseInt(valores[3]));
            
            anadir_asientos(valores[1], i, id_sala, index);
        }
        
        return true;
    }
    public boolean anadir_asientos(String id_funcion, int index_funcion, int id_sala, int index_sala)
    {
        String datos;
        String[] resultado = null;
        String[] valores = null;
        int id_cine = this.cines.getCineSeleccionado();
        
        datos = "9;" + id_funcion;
        
        resultado = cs.conexion(datos);
        
        System.out.println(resultado[0]);
        
        if (!resultado[0].equals(""))
        {
            for (int i = 0; i < resultado.length; i ++)
            {
                valores = resultado[i].split(":");

                this.cines.buscarCine(id_cine).buscarSala(index_sala).buscarFuncion(index_funcion).cargarAsiento(Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), Integer.parseInt(valores[2]), Boolean.getBoolean(valores[3]));
            }
        }
        
        return true;
    }
    public boolean ocupar_asiento(String asientos)
    {
        String datos = "11;" + asientos;
        
        String[] datos_obtenidos = null; 
        
        datos_obtenidos = cs.conexion(datos);
        
        return Boolean.parseBoolean(datos_obtenidos[0]);
    }
    public Integer[] convertirInt (String[] texto)
    {
        Integer numero[] = new Integer[texto.length];
        for (int i = 0; i < texto.length; i ++)
        {
            numero[i] = Integer.parseInt(texto[i]);
        }
        return numero;
    }
}
