package Logica;

import java.io.*;
import java.net.*;

public class ConexionServer {
    public String[] conexion(String datos)
    {
        Socket cliente = null;
        DataInputStream entrada = null;
        DataOutputStream salida = null;
        try {
            cliente = new Socket("localhost", 2000);
            salida = new DataOutputStream(cliente.getOutputStream());
            entrada = new DataInputStream(cliente.getInputStream());
        }
        catch (UnknownHostException excepcion) {
            System.err.println("No encuentro ‘localhost’");
        }
        catch (IOException excepcion) {
            System.err.println("Error de entrada/salida");
        }
        if (cliente != null && salida != null && entrada!= null) {
            try {
                String linea_recibida = null;
                salida.writeBytes(datos + "\n");
                linea_recibida = entrada.readLine();
                System.out.println("Servidor: " + linea_recibida);
                salida.close();
                entrada.close();
                cliente.close();
                return linea_recibida.split(";");
            }   
            catch (UnknownHostException excepcion) {
                System.err.println("No encuentro 'localhost'");
            }
            catch (IOException excepcion) {
                System.err.println("Error de entrada/salida");
            }
        }
        return null;
    }
}
