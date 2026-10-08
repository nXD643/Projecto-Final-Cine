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
        
        switch (Integer.parseInt(valores[0]))
        {
            case 1:
                datos_recibidos = ConexionDB.registro_cliente(valores[1]);
                break;
            case 2:
                datos_recibidos = ConexionDB.inicio_sesion(valores[1]);
                break;
            case 3: // Implementar en las funciones de la fachada
                datos_recibidos = ConexionDB.compras_cliente(valores[1]);
        }
        return datos_recibidos;
    }
}