package Persistencia;

import Modelo.Conexion;
import Modelo.Masajista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MasajistaData {

    private Connection con;

    public MasajistaData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }

    public void GuardarMasajista(Masajista masa) {
        try {
            String sql = "INSERT INTO masajista(matricula, nombre, apellido, telefono, especialidad, estado) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, masa.getMatricula());
            ps.setString(2, masa.getNombre());
            ps.setString(3, masa.getApellido());
            ps.setInt(4, masa.getTelefono());
            ps.setString(5, masa.getEspecialidad());
            ps.setBoolean(6, masa.isEstado());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Masajista guardada correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }

    public void eliminarMasajista(int matricula) {
        try {
            String sql = "DELETE FROM masajista WHERE matricula = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, matricula);

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Masajista eliminada correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }
    }

    public void actualizarMasajista(Masajista masaAc) {
        try {
            String sql = "UPDATE masajista SET nombre= ? ,apellido= ? ,telefono= ? ,especialidad= ? ,estado= ? WHERE matricula = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, masaAc.getNombre());
            ps.setString(2, masaAc.getApellido());
            ps.setInt(3, masaAc.getTelefono());
            ps.setString(4, masaAc.getEspecialidad());
            ps.setBoolean(5, masaAc.isEstado());
            ps.setInt(6, masaAc.getMatricula());

            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Actualizado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
    }

    public Masajista buscarInstalacion(int matricula) {
        Masajista masa = null;
        try {
            String sql = "SELECT * FROM instalacion WHERE idInstalacion = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, matricula);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int matri = rs.getInt("matricula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int telefono = rs.getInt("telefono");
                String especialidad = rs.getString("especialidad");
                boolean estado = rs.getBoolean("estado");

                masa = new Masajista(matricula,nombre,apellido,telefono, especialidad, estado);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return masa;
    }
    public void darDeBaja(Masajista masa) {
        try {
            if (!masa.isEstado()) {
                JOptionPane.showMessageDialog(null, "Ya está dado de baja!");
            }
            String slq = "UPDATE masajista SET estado = false WHERE matricula = ?";
            PreparedStatement ps = con.prepareStatement(slq);
            ps.setInt(1, masa.getMatricula());

            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Dado de baja correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja.");
        }
    }

    public void darDeAlta(Masajista masa) {
        try {
            if (masa.isEstado()) {
                JOptionPane.showMessageDialog(null, "Ya está dado de alta!");
            } else {
                String slq = "UPDATE masajista SET estado = true WHERE matricula = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, masa.getMatricula());

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
