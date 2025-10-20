package Persistencia;

import Modelo.Conexion;
import java.sql.Connection;

public class InstalacionData {
        private Connection con;
    
    public InstalacionData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }
    
    public void insertarInsatalacion(){
        
    }
}
