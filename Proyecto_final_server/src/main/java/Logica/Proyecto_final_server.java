package Logica;
public class Proyecto_final_server {

    public static void main(String[] args) {
        
        String registro = "1234567:Nana:mimi:jadhaida:4321";
        
        ConexionDB.registro_cliente(registro);
        
        String datos = "1234567:4321";
        
        String[] a = ConexionDB.inicio_sesion(datos);
        
        System.out.println(a[0]);
    }
}
