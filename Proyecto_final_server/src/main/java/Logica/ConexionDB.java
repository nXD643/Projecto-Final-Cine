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
    public static void registro_cliente(String datos)
    {
        try
        {
            String[] valores = datos.split(":");
            String sql = "call registro_cliente(?, ?, ?, ?, ?)";
            Connection connection = realizarConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, valores[0]);
            ps.setString(2, valores[1]);
            ps.setString(3, valores[2]);
            ps.setString(4, valores[3]);
            ps.setString(5, valores[4]);            
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
    }
    public static String[] inicio_sesion(String datos)
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
                datos_obtenidos += rs.getInt("documento") + ":" + rs.getString("nombre") + ":" + rs.getString("apellido") + ":" + rs.getString("correo_electronico") + ":" + rs.getString("contrasena") + ";";
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return datos_obtenidos.split(";");
    }
    
    public static String[] compras_cliente(String datos)
    {
        String datos_obtenidos = "";
        
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
                datos_obtenidos += rs.getInt("id") + ":" + rs.getInt("cliente_CI") + ":" + rs.getInt("entrada_ID") + ":" + rs.getDate("fecha") + ":" + rs.getString("hora") + rs.getString("metodo_pago") + rs.getString("motivo") + rs.getBoolean("estado") + ";";
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error con la sentencia MYSQL");
        }
        return datos_obtenidos.split(";");
    }
}
