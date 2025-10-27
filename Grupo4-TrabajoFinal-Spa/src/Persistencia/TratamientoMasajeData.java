package Persistencia;

import Modelo.Conexion;
import Modelo.Producto;
import Modelo.TratamientoMasaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TratamientoMasajeData {

    private Connection con;

    public TratamientoMasajeData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }

    public void guardarTratamiento(TratamientoMasaje trata) {
        try {
            List<Producto> productos = null;
            double total = 0;
            productos = trata.getProductos();
            for (Producto p : productos) {
                total += p.getCosto();
            }

            String sql = "INSERT INTO tratamiento/masaje(nombre, tipo, totalProductos, duracion, costo, estado) VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trata.getNombre());
            ps.setString(2, trata.getTipo());
            ps.setDouble(3, total);
            ps.setTime(4, trata.getDuracion());
            ps.setDouble(5, trata.getCosto());
            ps.setBoolean(6, trata.isActivo());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Tratamiento guardado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }
    
    public void eliminarTratamiento(int idTratamiento){
        String sql = "DELETE FROM tratamiento/masaje WHERE idTramiento = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTratamiento);
            
            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Masajista eliminada correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }       
    }
    
    public void actualizarTratamiento(TratamientoMasaje trata){
        
    }
    
}
