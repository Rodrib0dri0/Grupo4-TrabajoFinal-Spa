package Persistencia;

import Modelo.Conexion;
import Modelo.Instalacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class InstalacionData {

    private Connection con;

    public InstalacionData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }

    public void insertarInstalacion(Instalacion inst) {
        try {
            String sql = "INSERT INTO instalacion(nombre, uso, precio30m, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, inst.getNombre());
            ps.setString(2, inst.getDetalleDeUso());
            ps.setDouble(3, inst.getPrecio30m());
            ps.setBoolean(4, inst.isEstado());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Instalación guardada correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }

    public void eliminarInstalacion(int id) {
        try {
            String sql = "DELETE FROM instalacion WHERE idInstalacion = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Instalación eliminada correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }

    }

    public Instalacion buscarInstalacion(int id) {
        Instalacion insta = null;
        try {
            String sql = "SELECT * FROM instalacion WHERE idInstalacion = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("idInstalacion");
                String nombre = rs.getString("nombre");
                String detalleDeUso = rs.getString("uso");
                double precio30m = rs.getDouble("precio30m");
                boolean estado = rs.getBoolean("estado");

                insta = new Instalacion(nombre, detalleDeUso, precio30m, estado);
                insta.setIdInstalacion(ID); 
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return insta;
    }

    public void actualizar(Instalacion insA) {
        try {
            String sql = "UPDATE instalacion SET nombre= ?, uso= ?, precio30m = ?, estado = ? WHERE idInstalacion = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, insA.getNombre());
            ps.setString(2, insA.getDetalleDeUso());
            ps.setDouble(3, insA.getPrecio30m());
            ps.setBoolean(4, insA.isEstado());

            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Actualizado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
    }

    public void darDeBaja(Instalacion ins) {
        try {
            if (ins.isEstado()) {
                JOptionPane.showMessageDialog(null, "Ya está dado de alta!");
            } else {
                String slq = "UPDATE instalacion SET estado = false WHERE idInstalacion = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, ins.getIdInstalacion());

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Dado de baja correctamente!");
                }
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja.");
        }
    }

    public void darDeAlta(Instalacion ins) {
        try {
            if (ins.isEstado()) {
                JOptionPane.showMessageDialog(null, "Ya está dado de alta!");
            } else {
                String slq = "UPDATE instalacion SET estado = true WHERE idInstalacion = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, ins.getIdInstalacion());

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Dado de alta correctamente!");
                }
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta.");
        }
    }
}
