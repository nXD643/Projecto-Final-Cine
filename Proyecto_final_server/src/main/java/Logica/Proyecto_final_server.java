package Logica;

import java.io.*;
import java.net.*;

public class Proyecto_final_server {

    public static void main(String[] args) {
               
        String resultado;
        
        ServerSocket mi_servicio = null;
        String linea_recibida = null;
        DataInputStream entrada;
        PrintStream salida;
        Socket socket_conectado = null;
        try {
            mi_servicio = new ServerSocket(2000);
        }
        catch (IOException excepcion) {
            System.out.println(excepcion);
        }
        try {
            while (true)
            {
                socket_conectado = mi_servicio.accept();
                entrada = new DataInputStream(socket_conectado.getInputStream());
                salida = new PrintStream(socket_conectado.getOutputStream());
                while (true)
                {
                    linea_recibida = entrada.readLine();
                    if (linea_recibida == null)
                    {
                        break;
                    }
                    else
                    {
                        resultado = interpretador(linea_recibida);
                        
                        System.out.println(resultado);

                        salida.println(resultado);
                    }
                }
            }
            }
        catch (IOException excepcion) {
            System.out.println(excepcion);
        }
    }
    public static String interpretador(String datos)
    {        
        String[] valores = datos.split(";");
        String datos_recibidos = "";
        String[] telefonos = null;
        
        switch (Integer.parseInt(valores[0]))
        {
            case 1:
                datos_recibidos = ConexionDB.registro_cliente(valores[1]);
                break;
            case 2:
                datos_recibidos = ConexionDB.inicio_sesion(valores[1]);
                break;
            case 3:
                datos_recibidos = ConexionDB.compras_cliente(valores[1]);
                break;
            case 4:
                datos_recibidos = ConexionDB.obtenerCines();
                break;
            case 5:
                datos_recibidos = ConexionDB.obtenerSala(valores[1]);
                break;
            case 6:
                datos_recibidos = ConexionDB.obtenerFunciones(valores[1]);
                break;
            case 7:
                datos_recibidos = ConexionDB.obtenerPeliculas(valores[1]);
                break;
            case 8:
                datos_recibidos = ConexionDB.obtenerGeneros(valores[1]);
                break;
            case 9:
                datos_recibidos = ConexionDB.obtenerAsientos(valores[1]);
                break; 
            case 10:
                datos_recibidos = ConexionDB.entradas_compra(valores[1]);
                break;
            case 11:
                datos_recibidos = ConexionDB.ocuparAsiento(valores[1]);
                break; 
            case 12:
                telefonos = valores[1].split(":");
                datos_recibidos = ConexionDB.agregar_telefonos(telefonos[1], telefonos[0]);
                break;
            case 13:
                datos_recibidos = ConexionDB.eliminarTelefono(valores[1]);
                break;
            case 14:
                datos_recibidos = ConexionDB.anadirCompra(valores[1]);
                break;
            case 15:
                datos_recibidos = ConexionDB.cancelarCompra(valores[1]);
                break;
            case 16:
                datos_recibidos = ConexionDB.anadirEntrada(valores[1]);
                break;
        }
        return datos_recibidos;
    }
}