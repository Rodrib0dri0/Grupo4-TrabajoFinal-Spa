package Persistencia;

import Modelo.Conexion;
import java.sql.Connection;

public class SesionData {
    private Connection con;
    
    public SesionData(){
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }
}
