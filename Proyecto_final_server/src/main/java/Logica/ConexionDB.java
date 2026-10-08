package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDB {

    public ConexionDB() {
    }
    
    public static boolean conectar()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public static Connection realizarConexion()
    {
        String url = "jdbc:mysql://localhost:3306/complejo_cines";
        String usuario = "root";
        String clave = "";
        Connection conexion = null;
        try
        {
            conexion = DriverManager.getConnection(url, usuario, clave);
        }
        catch (SQLException e)
        {
            System.out.println("Error en conexion MYSQL");
        }
        return conexion;
    }
    public static String registro_cliente(String datos)
    {
        try
        {
            String[] valores = datos.split(":");
            String[] telefono = valores[5].split("/");
            String sql = "call registro_cliente(?, ?, ?, ?, ?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ps.setString(2, valores[1]);
            ps.setString(3, valores[2]);
            ps.setString(4, valores[3]);
            ps.setString(5, valores[4]);            
            ps.executeUpdate();
            
            for (int i = 0; i < telefono.length; i ++)
            {
                agregar_telefonos(telefono[i], valores[0]);
            }
            
            return "true";
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return "false";
    }
    public static String inicio_sesion(String datos)
    {
        String datos_obtenidos = "";
        
        try
        {
            String[] valores = datos.split(":");
            String sql = "call inicio_sesion(?, ?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ps.setString(2, valores[1]);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                datos_obtenidos += rs.getInt("documento") + ":" + rs.getString("nombre") + ":" + rs.getString("apellido") + ":" + rs.getString("correo_electronico") + ":" + rs.getString("contrasena") + ":";
            }
            String telefonos = obtener_telefonos(valores[0]);
            telefonos = telefonos.substring(0, telefonos.length() - 1) + ';';
            datos_obtenidos += telefonos;
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return datos_obtenidos;
    }
    
    public static String compras_cliente(String datos)
    {
        String datos_obtenidos = "";
        System.out.println(datos);
        try
        {
            String[] valores = datos.split(":");
            String sql = "call compras_cliente(?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                datos_obtenidos += rs.getInt("id") + ":" + rs.getInt("cliente_CI") + ":" + rs.getDate("fecha") + ":" + rs.getString("hora") + rs.getString("metodo_pago") + rs.getString("motivo") + rs.getBoolean("estado") + ";";
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return datos_obtenidos;
    }
    
    public static String[] entradas_compra(String datos)
    {
        String datos_obtenidos = "";
        
        try
        {
            String[] valores = datos.split(":");
            String sql = "call entradas_compra(?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                datos_obtenidos += rs.getInt("id") + ":" + rs.getInt("precio_pagado") + ":" + rs.getInt("asiento_ID") + ":" + rs.getInt("sala_ID") + ":" + rs.getInt("cine_ID") + rs.getInt("funcion_ID") + rs.getInt("compra_ID") + ";";
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return datos_obtenidos.split(";");
    }
    
    public static String[] obtenerCines()
    {
        String datos_obtenidos = "";
        
        try
        {
            String sql = "call get_cines()";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                datos_obtenidos += rs.getInt("id") + ":" + rs.getString("calle") + ":" + rs.getString("nombre") + ";";
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return datos_obtenidos.split(";");
    }
        
    public static String[] obtenerSala(String datos)
    {
        String datos_obtenidos = "";
        
        try
        {
            String[] valores = datos.split(":");
            String sql = "call get_salas(?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                datos_obtenidos += rs.getInt("id") + ":" + rs.getInt("cine_ID") + ":" + rs.getInt("numero") + ":" + rs.getInt("capacidad") + ";";
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return datos_obtenidos.split(";");
    }
    public static String[] obtenerFunciones(String datos)
    {
        String datos_obtenidos = "";
        
        try
        {
            String[] valores = datos.split(":");
            String sql = "call get_funciones(?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                datos_obtenidos += rs.getInt("id") + ":" + rs.getInt("sala_Id") + ":" + rs.getInt("cine_ID") + ":" + rs.getDate("fecha") + ":" + rs.getString("hora") + rs.getInt("precio_base") + ";";
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return datos_obtenidos.split(";");
    }
    public static String[] obtenerAsientos(String datos)
    {
        String datos_obtenidos = "";
        
        try
        {
            String[] valores = datos.split(":");
            String sql = "call get_asientos(?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                datos_obtenidos += rs.getInt("id") + ":" + rs.getInt("sala_Id") + ":" + rs.getInt("cine_ID") + ":" + rs.getString("fila") + ":" + rs.getInt("numero") + ";";
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return datos_obtenidos.split(";");
    }
    public static boolean anadirCompra(String datos)
    {
        try
        {
            String[] valores = datos.split(":");
            String sql = "call add_compra(?, ?, ?, ?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ps.setString(2, valores[1]);
            ps.setString(3, valores[2]);
            ps.setString(4, valores[3]);
            ResultSet rs = ps.executeQuery();
            
            return true;
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return false;
    }
    public static boolean anadirEntrada(String datos)
    {
        try
        {
            String[] valores = datos.split(":");
            String sql = "call add_entrada(?, ?, ?, ?, ?, ?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ps.setString(2, valores[1]);
            ps.setString(3, valores[2]);
            ps.setString(4, valores[3]);
            ps.setString(5, valores[4]);
            ps.setString(6, valores[5]);
            ResultSet rs = ps.executeQuery();
            
            return true;
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return false;
    }
    public static boolean cancelarCompra(String datos)
    {
        try
        {
            String[] valores = datos.split(":");
            String sql = "call cancelar_compra(?, ?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ps.setString(2, valores[1]);
            ResultSet rs = ps.executeQuery();
            
            return true;
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return false;
    }
    public static boolean agregar_telefonos(String telefonos, String documento)
    {
        try
        {
            String sql = "call agregar_telefono(?, ?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, documento);
            ps.setString(2, telefonos);
            ResultSet rs = ps.executeQuery();
            
            return true;
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return false;
    }
    public static String obtener_telefonos(String documento)
    {
        String datos_obtenidos = "";
        
        try
        {
            String sql = "call obtener_telefono(?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, documento);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                datos_obtenidos += rs.getString("telefono") + "/";
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return datos_obtenidos;
    }
    public static String obtenerPeliculas(String IDcine) {
        return "";// obtiene las peliculas de la base de datos
    }
}
