package Persistencia;

import Modelo.Conexion;
import Modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.*;

public class ServicioData {

    private Connection con;

    public ServicioData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }

    public void guardarTratamiento(Servicio servicio) {
        try {

            String sql = "INSERT INTO servicio (nombre, tipo, detalle, duracion, costo, estado) VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, servicio.getNombre());
            ps.setString(2, servicio.getTipo());
            ps.setString(3, servicio.getDetalle());
            ps.setInt(4, servicio.getDuracion());
            ps.setDouble(5, servicio.getCosto());
            ps.setBoolean(6, servicio.isEstado());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Servicio guardado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }

    public void eliminarTratamiento(int id) {
        try {
            String sql = "DELETE FROM servicio WHERE idServicio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Tratamiento eliminado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }
    }

    public void actualizarTratamiento(Servicio trata) {
        try {
            String sql = "UPDATE servicio servicio SET nombre = ?,tipo= ?, duracion= ?,costo= ?,detalle =? ,estado= ? WHERE idServicio = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trata.getNombre());
            ps.setString(2, trata.getTipo());
            ps.setInt(3, trata.getDuracion());
            ps.setDouble(4, trata.getCosto());
            ps.setString(5, trata.getDetalle());
            ps.setBoolean(6, trata.isEstado());
            ps.setInt(7, trata.getIdServicio());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Servicio actualizado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
    }

    public Servicio buscarServicio(int id) {
        Servicio tra = null;
        try {
            String sql = "SELECT * FROM servicio WHERE idServicio = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTratamiento = rs.getInt("idServicio");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int duracion = rs.getInt("duracion");
                double costo = rs.getDouble("costo");
                String detalle = rs.getString("detalle");
                boolean estado = rs.getBoolean("estado");

                tra = new Servicio(nombre, tipo, duracion, detalle, costo, estado);
                tra.setIdServicio(idTratamiento);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return tra;
    }

    public List<Servicio> traerServicios() {
        List<Servicio> productos = new ArrayList();
        try {
            String sql = "SELECT * FROM servicio";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idS = rs.getInt("idServicio");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int duracion = rs.getInt("duracion");
                String detalle = rs.getString("detalle");
                double costo = rs.getDouble("costo");
                boolean estado = rs.getBoolean("estado");
                Servicio servi = new Servicio(nombre, tipo, duracion, detalle, costo, estado);
                servi.setIdServicio(idS);
                productos.add(servi);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer los servicios.");
        }
        return productos;
    }

    public boolean estadoActual(int id) {
        boolean estado = true;
        try {
            String slq = "SELECT estado FROM servicio WHERE idServicio = ?";
            PreparedStatement ps = ps = con.prepareStatement(slq);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                boolean es = rs.getBoolean("estado");
                estado = es;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return estado;

    }

    public void darDeBaja(int id) {
        try {
            if (estadoActual(id)) {
                String slq = "UPDATE servicio SET estado = false WHERE idServicio = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, id);

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Dado de baja correctamente!");
                }
                ps.close();
            } else {
                JOptionPane.showMessageDialog(null, "Ya está dado de baja!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja.");
        }
    }

    public void darDeAlta(int id) {
        try {
            if (!estadoActual(id)) {
                String slq = "UPDATE servicio SET estado = true WHERE idServicio = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, id);

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Dado de alta correctamente!");
                }
                ps.close();
            } else {
                JOptionPane.showMessageDialog(null, "Ya está dado de alta!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta.");
        }
    }
}
