package Persistencia;

import Modelo.Conexion;
import Modelo.Instalacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }
    
    public void eliminarInstalacion(int id){
        try {
            String sql = "DELETE FROM instalacion WHERE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int registro = ps.executeUpdate();
            
            if(registro > 0){
                JOptionPane.showMessageDialog(null, "Instalación eliminada correctamente!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }
        
        
    }
}
