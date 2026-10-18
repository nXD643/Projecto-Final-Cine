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
        
        //fachada.inicio_sesion(58376015, "2931sofia");
                
        //fachada.anadir_cines();
    }
}