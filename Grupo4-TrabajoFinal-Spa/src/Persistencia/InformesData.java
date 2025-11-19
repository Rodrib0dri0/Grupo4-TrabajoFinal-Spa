package Persistencia;

import Modelo.Conexion;
import Modelo.Instalacion;
import Modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.swing.JOptionPane;

public class InformesData {

    private Connection con;
    private ServicioData sd = new ServicioData();

    public InformesData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }

    public Map<Servicio, Integer> instaUsadas() {
        Map<Servicio, Integer> servicio = new HashMap();
        Servicio servi = null;
        try {
            String sql = "SELECT s.idServicio,s.nombre, COUNT(tm.idServicio) AS usos \n"
                    + "FROM tratamiento_masaje tm \n"
                    + "JOIN servicio s ON tm.idServicio = s.idServicio \n"
                    + "GROUP by s.idServicio \n"
                    + "ORDER BY usos \n"
                    + "DESC LIMIT 5";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idServicio");
                int usos = rs.getInt("usos");

                servi = sd.buscarServicio(id);

                servicio.put(servi, usos);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return servicio;
    }
}
