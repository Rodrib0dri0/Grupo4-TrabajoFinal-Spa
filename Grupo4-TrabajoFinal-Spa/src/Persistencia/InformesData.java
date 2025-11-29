package Persistencia;

import Modelo.Conexion;
import Modelo.Instalacion;
import Modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.swing.JOptionPane;

public class InformesData {

    private Connection con;
    private ServicioData sd = new ServicioData();
    private InstalacionData insd = new InstalacionData();

    public InformesData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }

    public Map<Servicio, Integer> serviUsadas() {
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

    public Map<Instalacion, Integer> instaMasUsadas(LocalDateTime feI, LocalDateTime feF) {
        Map<Instalacion, Integer> instalaciones = new HashMap();
        Instalacion insta = null;
        try {
            String sql = "SELECT COUNT(si.idInstalacion) AS usos, i.idInstalacion\n"
                    + "FROM sesion s \n"
                    + "JOIN sesion_instalacion si ON s.idSesion = si.idSesion \n"
                    + "JOIN instalacion i ON si.idInstalacion = i.idInstalacion\n"
                    + "WHERE fecha_hora_inicio BETWEEN ? AND ?\n"
                    + "GROUP BY i.idInstalacion";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(feI));
            ps.setTimestamp(2, Timestamp.valueOf(feF));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idInstalacion");
                int usos = rs.getInt("usos");

                insta = insd.buscarInstalacion(id);

                instalaciones.put(insta, usos);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar instalación-más-usadas.");
        }
        return instalaciones;
    }

    public Map<Instalacion, Integer> instaUsadas() {
        Map<Instalacion, Integer> instalaciones = new HashMap();
        Instalacion insta = null;
        try {
            String sql = "SELECT COUNT(si.idInstalacion) AS usos, i.idInstalacion\n"
                    + "FROM sesion s \n"
                    + "JOIN sesion_instalacion si ON s.idSesion = si.idSesion \n"
                    + "JOIN instalacion i ON si.idInstalacion = i.idInstalacion\n"
                    + "GROUP BY i.idInstalacion";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idInstalacion");
                int usos = rs.getInt("usos");

                insta = insd.buscarInstalacion(id);

                instalaciones.put(insta, usos);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar instalación-usadas:" + ex);
        }
        return instalaciones;
    }
}
