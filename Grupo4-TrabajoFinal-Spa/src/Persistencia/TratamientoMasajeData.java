package Persistencia;

import Modelo.Conexion;
import Modelo.Producto;
import Modelo.TratamientoMasaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
    ProductosData pd = new ProductosData();

    public void guardarTratamiento(TratamientoMasaje trata) {
        try {
            List<Producto> productos = null;
            double total = 0;
            productos = trata.getProductos();
            for (Producto p : productos) {
                total += p.getCosto();
            }

            String sql = "INSERT INTO tratamiento/masaje(nombre, tipo, totalProductos, duracion, costo, detalle, estado) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trata.getNombre());
            ps.setString(2, trata.getTipo());
            ps.setDouble(3, total);
            ps.setInt(4, trata.getDuracion());
            ps.setDouble(5, trata.getCosto());
            ps.setString(6, trata.getDetalle());
            ps.setBoolean(7, trata.isActivo());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Tratamiento guardado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }

    public void eliminarTratamiento(int idTratamiento) {
        try {
            String sql = "DELETE FROM tratamiento/masaje WHERE idTramiento = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTratamiento);

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Tratamiento eliminado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }
    }

    public void actualizarTratamiento(TratamientoMasaje trata) {
        try {
            List<Producto> productos = null;
            double total = 0;
            productos = trata.getProductos();
            for (Producto p : productos) {
                total += p.getCosto();
            }

            String sql = "UPDATE tratamiento/masaje SET nombre = ?,tipo= ?,totalProductos= ?,duracion= ?,costo= ?,detalle =? ,estado= ? WHERE idTratamiento = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trata.getNombre());
            ps.setString(2, trata.getTipo());
            ps.setDouble(3, total);
            ps.setInt(4, trata.getDuracion());
            ps.setDouble(5, trata.getCosto());
            ps.setString(6, trata.getDetalle());
            ps.setBoolean(7, trata.isActivo());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Tratamiento actualizado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
    }

    public TratamientoMasaje buscarTratamiento(int id) {
        TratamientoMasaje tra = null;
        try {
            String sql = "SELECT * FROM `tratamiento/masaje` WHERE idTratamiento = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            int idTratamiento = rs.getInt("idTratamiento");
            String nombre = rs.getString("nombre");
            String tipo = rs.getString("tipo");
            List<Producto> productos = pd.buscarProductos(id);
            int duracion = rs.getInt("duracion");
            double costo = rs.getDouble("costo");
            String detalle = rs.getString("detalle");
            boolean estado = rs.getBoolean("estado");

            tra = new TratamientoMasaje(idTratamiento, nombre, tipo, detalle, duracion, costo, estado);
            tra.setProductos(productos);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return tra;
    }
    //Falta metodos de alta/baja
}
