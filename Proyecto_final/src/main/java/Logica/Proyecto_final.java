package Logica;

import java.sql.*;
import java.time.*;
import Grafica.Presentacion;
import com.formdev.flatlaf.FlatDarkLaf;

public class Proyecto_final {
    public static void main(String[] args) {
        Fachada fachada = Fachada.getInstancia();
        
        FlatDarkLaf.setup();
        Presentacion ventana = new Presentacion();
        ventana.setVisible(true);
    }
}