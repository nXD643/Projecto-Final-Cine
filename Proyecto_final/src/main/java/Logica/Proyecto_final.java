package Logica;

import java.sql.*;
import java.time.*;
import Grafica.Presentacion;

public class Proyecto_final {
    public static void main(String[] args) {
        
        
        
        LocalDate fecha = LocalDate.of(2026, 7, 20);
        
        LocalDate fecha2 = LocalDate.of(1990, 2, 1);
        
        //System.out.println(fecha);
        
        Date date = Date.valueOf(fecha2);
        
        //System.out.println(date);
        
        LocalDate fechita = date.toLocalDate();
        
        //System.out.println(fechita);
        
        LocalDateTime horita = LocalDateTime.now();
        
        LocalDate ahora = horita.toLocalDate();
        
        //System.out.println(ahora);
        //System.out.println(horita);
        
        LocalDateTime localDateTime2 = ahora.atTime(LocalTime.now());
        
        //System.out.println(localDateTime2);
        
        
        String fecha_hora = fecha.toString() + "T10:01:23.6479";
        
        //System.out.println(fecha_hora);
        LocalDateTime parseada=LocalDateTime.parse(fecha_hora);
        if (localDateTime2.isBefore(parseada)){
            //System.out.println("Holaaa");
        }
                
        // El atributo duracion pelicula queda como string modificar clases, der y er y UML
        
        Fachada f = Fachada.getInstancia();
        
        f.verificarCedula(58376015);
        
        System.out.println(f.verificarTarjeta("4003600000000014"));
        
        Presentacion ventana_inicio = new Presentacion();
        ventana_inicio.setVisible(true);
    }
}