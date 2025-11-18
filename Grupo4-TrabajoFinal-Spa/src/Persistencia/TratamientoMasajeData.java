package Persistencia;

import Modelo.Conexion;
import Modelo.Producto;
import Modelo.TratamientoMasaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
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

            String sql = "INSERT INTO tratamiento_masaje(idServicio ,detalle, precio, estado) VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, trata.getIdServicio());
            ps.setString(2, trata.getDetalle());
            ps.setDouble(3, trata.getPrecio());
            ps.setBoolean(4, trata.isEstado());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int idT = rs.getInt(1);
                    if (!trata.getProductos().isEmpty()) {
                        guardarProductos(idT, trata.getProductos());
                    }
                }
                JOptionPane.showMessageDialog(null, "Tratamiento guardado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }

    public void guardarProductos(int idTrata, List<Producto> productos) {

        try {
            String sql = "INSERT INTO tratamiento_producto(idTratamiento, idProducto) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            for (Producto p : productos) {
                ps.setInt(1, idTrata);
                ps.setInt(2, p.getIdProducto());
                ps.execute();
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar productos.");
        }
    }

    public void eliminarTratamiento(int idTratamiento) {
        try {
            String sql = "DELETE FROM tratamiento_masaje WHERE idTratamiento = ?";
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

    /* public void actualizarTratamiento(TratamientoMasaje trata) {
        try {
            String sql = "UPDATE tratamiento/masaje SET nombre = ?,tipo= ?,totalProductos= ?,duracion= ?,costo= ?,detalle =? ,estado= ? WHERE idTratamiento = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trata.getNombre());
            ps.setString(2, trata.getTipo());
            ps.setDouble(3, trata.getProducto().getIdProducto());
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
     */
    public TratamientoMasaje buscarTratamiento(int id) {
        TratamientoMasaje tra = null;
        List<Producto> productos = traerProductosTrata(id);
        try {
            String sql = "SELECT * FROM tratamiento_masaje WHERE idTratamiento = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            int idTratamiento = rs.getInt("idTratamiento");
            int idServi = rs.getInt("idServico");
            double precio = rs.getDouble("precio");
            String detalle = rs.getString("detalle");
            boolean estado = rs.getBoolean("estado");

            tra = new TratamientoMasaje(productos, idServi, detalle, precio, estado);
            tra.setIdTratamiento(idTratamiento);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return tra;
    }

    public List<Producto> traerProductosTrata(int idTrata) {
        List<Producto> productos = new ArrayList();
        try {
            String sql = "SELECT * FROM productos p JOIN tratamiento_producto tp ON p.idProducto = tp.idProducto WHERE idTratamiento = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTrata);

            ResultSet rs = ps.executeQuery();

            int idP = rs.getInt("idProducto");
            String nombre = rs.getString("nombre");
            String marca = rs.getString("marca");
            String tipo = rs.getString("tipo");
            double costo = rs.getDouble("precio");
            boolean estado = rs.getBoolean("estado");
            Producto produ = new Producto(nombre, marca, tipo, costo, estado);
            produ.setIdProducto(idP);

            productos.add(produ);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return productos;
    }
    //Falta metodos de alta/baja
}
