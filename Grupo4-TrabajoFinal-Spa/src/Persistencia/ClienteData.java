package Persistencia;

import Modelo.Conexion;
import java.sql.Connection;

public class ClienteData {
    
    private Connection con;
    
    public ClienteData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }
    
    public void agregarCliente (Cliente cliente){
        String sql = "INSERT INTO cliente(dni, nombre, apellido, edad, afecciones, estado, telefono) VALUES (?,?,?,?,?,?,?)";
        
        
    }
}
