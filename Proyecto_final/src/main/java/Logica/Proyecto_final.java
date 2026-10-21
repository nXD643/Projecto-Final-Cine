package Logica;

import java.sql.*;
import java.time.*;
import Grafica.Menus.Presentacion;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;

public class Proyecto_final {
    public static void main(String[] args) {
        Fachada fachada = Fachada.getInstancia();
        
        FlatDarkLaf.setup();
        Presentacion ventana = new Presentacion();
        ventana.setVisible(true);   
        
        fachada.anadir_cines();
        
        //fachada.inicio_sesion(58376015, "2931sofia");
        
        //fachada.getCliente().guardarTelefono(58376015, "7126371932:98286318:867413923");
        
        //LocalDate fecha = LocalDate.parse("2026-10-12");
        
        //fachada.getCliente().guardarCompras(58376015, fecha, "10:12", "tarjeta", 300);
        
        //fachada.getCliente().eliminarTelefono("7126371932");
        
        //fachada.getCliente().cancelarCompra(5, "Porque si");
        
        //System.out.println(fachada.getCliente().buscarCompras(0).guardarEntrada(1000, 1, 1, 1, 6, 5));
        
        //System.out.println(fachada.ocupar_asiento("6"));
    }
}